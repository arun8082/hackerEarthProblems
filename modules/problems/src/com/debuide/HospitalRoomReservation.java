package com.debuide;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum RoomTypes {
	NORMAL_ROOM, OXYGEN_ROOM, ICU
}

enum Types {
	NORMAL_ROOM, OXYGEN_ROOM, ICU, FLAT_BED, RECLINER_BED, VENTILATOR, OXYGEN_CYLINDER, NORMAL_MASKS,
	NON_REBREATHER_MASKS
}

public class HospitalRoomReservation {
	/* Used for generate reference id */
	static int idCounter ;
	static {
		idCounter=100;
	}
	/* used to keep track of all requirements based on room type */
	Map<Types, Map<Types, Integer>> rerourceRequirements = new HashMap<Types, Map<Types, Integer>>();
	/* Used to store available quantity */
	Map<Types, Integer> availableQuantity = new HashMap<Types, Integer>();
	/* Used to store ref id and room type */
	Map<Integer, Types> reservation = new HashMap<Integer, Types>();

	/**
	 * Constructor to initialize all available equipments and rooms
	 */
	public HospitalRoomReservation() {
		// Stores rooms quantity
		availableQuantity.put(Types.NORMAL_ROOM, 50);
		availableQuantity.put(Types.OXYGEN_ROOM, 50);
		availableQuantity.put(Types.ICU, 20);

		// Stores equipments quantity
		availableQuantity.put(Types.VENTILATOR, 16);
		availableQuantity.put(Types.OXYGEN_CYLINDER, 110);
		availableQuantity.put(Types.NORMAL_MASKS, 200);
		availableQuantity.put(Types.NON_REBREATHER_MASKS, 120);

		// Stores Beds quantity
		availableQuantity.put(Types.FLAT_BED, 80);
		availableQuantity.put(Types.RECLINER_BED, 100);

		// Required resources for Normal BED
		Map<Types, Integer> requiredResources = new HashMap<Types, Integer>();
		requiredResources.put(Types.FLAT_BED, 1);
		requiredResources.put(Types.NORMAL_MASKS, 2);
		rerourceRequirements.put(Types.NORMAL_ROOM, requiredResources);

		// Required resources for Oxygen Room
		requiredResources = new HashMap<Types, Integer>();
		requiredResources.put(Types.OXYGEN_CYLINDER, 2);
		requiredResources.put(Types.RECLINER_BED, 1);
		requiredResources.put(Types.NON_REBREATHER_MASKS, 2);
		rerourceRequirements.put(Types.OXYGEN_ROOM, requiredResources);

		// Required resources for ICU
		requiredResources = new HashMap<Types, Integer>();
		requiredResources.put(Types.VENTILATOR, 1);
		requiredResources.put(Types.RECLINER_BED, 1);
		requiredResources.put(Types.OXYGEN_CYLINDER, 1);
		rerourceRequirements.put(Types.ICU, requiredResources);
	}

	public void getRemainingRooms() {
		System.out.println("Remaining availability:");
		for (RoomTypes rtype : RoomTypes.values()) {
			Types t = Types.valueOf(rtype.toString());
			int qty = getAvailability(t);
			if (qty == 0) {
				System.out.println(t + ": N/A");
			} else {
				System.out.println(t + ":" + qty);
			}
		}
		System.out.println();
	}

	/**
	 * Get availability based on the given room type from the all available
	 * equipments
	 * 
	 * @param rtype
	 * @return
	 * @author Arunendra Kumar
	 */
	public int getAvailability(Types rtype) {
		Map<Types, Integer> req = rerourceRequirements.get(rtype);
		int roomQty = availableQuantity.get(Types.valueOf(rtype.toString()));
		int count = roomQty;

		for (Map.Entry<Types, Integer> equipment : req.entrySet()) {
			int reqQty = equipment.getValue();
			int avQty = availableQuantity.get(equipment.getKey());
			int t = avQty / reqQty;
			if (count > t) {
				count = t;
			}
//			System.out.println(equipment.getKey()+":"+reqQty+":"+avQty);
		}
		return count;
	}

	/**
	 * Get the availability of required equipments and reserve room based on
	 * conditions
	 * 
	 * @param rtype
	 * @author Arunendra Kumar
	 */
	public void reservation(Types rtype) {
		int qty = getAvailability(rtype);
		if (qty > 0) {
			availableQuantity.put(rtype, qty - 1);

			Map<Types, Integer> reqRes = rerourceRequirements.get(rtype);
			for (Map.Entry<Types, Integer> res : reqRes.entrySet()) {
				availableQuantity.put(res.getKey(), availableQuantity.get(res.getKey()) - res.getValue());
			}

			reservation.put(idCounter++, rtype);
			printDetails(rtype);
		} else {
			System.out.println("Sorry, no rooms could be reserved.");
		}
		getRemainingRooms();
	}

	/**
	 * Prints final reservation message with required equipment quantity
	 * 
	 * @param rtype
	 * @author Arunendra Kumar
	 */
	public void printDetails(Types rtype) {
		Map<Types, Integer> req = rerourceRequirements.get(rtype);
		StringBuffer sb = new StringBuffer("01 " + rtype.toString() + " with (");
		for (Map.Entry<Types, Integer> r : req.entrySet()) {
			sb.append(r.getValue() + " " + r.getKey().toString() + " + ");
		}
		sb.replace(sb.length() - 3, sb.length(), "");
		sb.append(" ) reserved. Ref ID: " + (idCounter - 1));
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		HospitalRoomReservation hs = new HospitalRoomReservation();
		Scanner sc = new Scanner(System.in);
		// Execution block
		while (true) {
			// Input block
			Types rtype = null;
			while (true) {
				System.out.println("Please enter the type of room you want to reserve(for exit enter q/Q):");
				String input = sc.nextLine();
				if (input.equalsIgnoreCase("q")) {
					System.out.println("Thank you for using :)");
					if(sc!=null) {
						sc.close();
					}
					System.exit(0);
				}
				input = input.trim().replace(" ", "_").toUpperCase();
				try {
					rtype = Types.valueOf(input);
					break;
				} catch (Exception e) {
					System.out.println("oh-ho Invalid room type, Try Again!:)\n");
					continue;
				}
			}
			hs.reservation(rtype);
		}		
	}

}
