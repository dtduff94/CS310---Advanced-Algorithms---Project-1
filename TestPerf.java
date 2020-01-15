import edu.princeton.cs.algs4.In;
//import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.SequentialSearchST;

public class TestPerf {
    private int words = 0;
    private ST<String, Integer> st;
    private SeparateChainingHashST<String, Integer> schst;
    private LinearProbingHashST<String, Integer> lphst;
    private SequentialSearchST<String, Integer> ssst;

    public TestPerf(String textfile) {
	In text = new In(textfile);
	
	String[] keys = text.readAllStrings();

	this.st = new ST<>();
	long time1 = System.currentTimeMillis();
	for (int i = 0; i < keys.length; i++) {
	    words++;
	    if (st.contains(keys[i])) {
		st.put(keys[i], st.get(keys[i]) + 1);
	    }
	    else {
		st.put(keys[i], 1);
	    }
	}
	long time2 = System.currentTimeMillis();
	System.out.println(time2 - time1);

	this.schst = new SeparateChainingHashST<>();
	long time3 = System.currentTimeMillis();
        for (int i = 0; i < keys.length; i++) {
            if (schst.contains(keys[i])) {
                schst.put(keys[i], schst.get(keys[i]) + 1);
            }
            else {
                schst.put(keys[i], 1);
            }
        }
        long time4 = System.currentTimeMillis();
	System.out.println(time4 - time3);
	
	this.lphst = new LinearProbingHashST<>();
	long time5 = System.currentTimeMillis();
        for (int i = 0; i < keys.length; i++) {
            if (lphst.contains(keys[i])) {
                lphst.put(keys[i], lphst.get(keys[i]) + 1);
            }
            else {
                lphst.put(keys[i], 1);
            }
        }
        long time6 = System.currentTimeMillis();
	System.out.println(time6 - time5);
	
	this.ssst = new SequentialSearchST<>();
	long time7 = System.currentTimeMillis();
        for (int i = 0; i < keys.length; i++) {
            if (ssst.contains(keys[i])) {
                ssst.put(keys[i], ssst.get(keys[i]) + 1);
            }
            else {
                ssst.put(keys[i], 1);
            }
        }
        long time8 = System.currentTimeMillis();
	System.out.println(time8 - time7);
    }

    public void printStats() {
	System.out.println(words);
	System.out.println(st.size());

	String max = " ";
    	st.put(max, 0);
	for (String word : st.keys()) {
	    if (st.get(word) > st.get(max)) {
		max = word;
	    }
	}

	System.out.println(max + " " + st.get(max));
    }

    public static void main(String[] args) {
	TestPerf testperf = new TestPerf(args[0]);
	testperf.printStats();
    }
}