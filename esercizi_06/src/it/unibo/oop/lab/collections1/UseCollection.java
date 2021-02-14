package it.unibo.oop.lab.collections1;

import java.util.*;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int INIZ = 1_000;
	private static final int FIN = 2_000;
	private static final int N_ELEM = 100_000;
	private static final int N_READ = 1_000;
	private static final int TO_MS = 1_000_000;
	
	private static final long AFRICA = 1_110_635_000L;
	private static final long AMERICAS = 972_005_000L;
	private static final long ANTARCTICA = 0L;
	private static final long ASIA = 4_298_723_000L;
	private static final long EUROPE = 742_452_000L;
	private static final long OCEANIA = 38_304_000L;
	
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final List<Integer> list = new ArrayList<>();
    	
    	for (int i = INIZ; i < FIN; i++) {
    		list.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	//final List<Integer> list2 = new LinkedList<>();
    	//list2.addAll(list);
    	final List<Integer> list2 = new LinkedList<>(list);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	final int temp = list.get(0);
    	list.set(0, list.get(list.size() - 1));
    	list.set(list.size() - 1, temp);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (final int elem : list) {
    		System.out.println(elem);
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime();  //Prepare a variable for measuring time
    	
    	for (int i = 1; i <= N_ELEM; i++) {
    		list.add(i);
    		list2.add(i);
    	}
    	
    	time = System.nanoTime() - time;  //Compute the time
    	System.out.println("Time required to add elements in AList and LList: " + time + "ns (" + time / TO_MS + "ms)");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	int half = (int) list.size() / 2;
    	int half2 = (int) list2.size() / 2;
    	time = System.nanoTime();
    	
    	for (int i = 1; i <= N_READ; i++) {
    		list.get(half);
    		list2.get(half2);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Time required to read element from AList and LList: " + time + "ns (" + time / TO_MS + "ms)");
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	Map<String, Long> world = new HashMap<>();
    	world.put("Africa", AFRICA);
    	world.put("Americas", AMERICAS);
    	world.put("Antarctica", ANTARCTICA);
    	world.put("Asia", ASIA);
    	world.put("Europe", EUROPE);
    	world.put("Oceania", OCEANIA);
    	
        /*
         * 8) Compute the population of the world
         */
    	long totPopulation = 0;
    	for (final long pop : world.values()) {
    		totPopulation += pop;
    	}
    	System.out.println("Population of the world: " + totPopulation);
    	
    }
}
