package HashTables;

public class Main {
	public static void main(String[] args) {
		// Map<Integer, String> map = new HashMap<>();
//		
//		map.put(1, "Hawler");
//		map.put(2, "Slemani");
//		map.put(3, "Halabja");
//		map.put(9, "Dhok");
//		map.put(4, "");
//		map.put(5, null);
//		
//		System.out.println("Key: " + map.containsKey(7));
//		System.out.println("Value: " + map.containsValue("Dhok"));
//		System.out.println(map.get(3));
//		System.out.println(map);
//
//		for (int item : map.keySet())
//			System.out.println("key: " + item);
//			
//		for (Entry<Integer, String> name : map.entrySet())
//			System.out.println("Entry: " + name);
//		

		HashTable h = new HashTable();
		h.put(5, "mhamad");
		h.put(10, "mhamad ali");
		h.put(15, "hunar");
		h.put(20, "darbaz");
		h.remove(5);
		System.out.println("----------------");
		secondHashMap s = new secondHashMap();
		s.put(5, "bahoz");
		s.put(10, "zaka");
		s.put(15, "hunar");
		s.put(20, "hamid");
		s.put(25, "kurd");
		s.remove(5);
		System.out.println("get: " + s.get(15));

	}
}
