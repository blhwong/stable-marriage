import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Matching {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner lists = null;
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<ArrayList<Integer>> mpref = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> npref = new ArrayList<ArrayList<Integer>>();
		
		int m, n, handle;
		try {
			lists = new Scanner(new BufferedReader(new FileReader("./src/3-10-3.in")));
			m = lists.nextInt();
			n = lists.nextInt();
			//int handle = lists.nextInt();
//			System.out.println(m);
//			System.out.println(n);
			for(int a = 0; a < m; a++)
			{
				handle = lists.nextInt();
				for(int b = 0; b< handle; b++)
				{
					q.add(a);
				}
			}
			
			for(int b = 0; b < m; b++)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for(int c = 0; c < n; c++)
				{
					temp.add(lists.nextInt());
				}
				mpref.add(temp);
			}
			for(int d = 0; d < n; d++)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for(int e = 0; e < m; e++)
				{
					temp.add(lists.nextInt());
				}
				npref.add(temp);
			}
			
			ArrayList<Integer> mindex = new ArrayList<Integer>();
			ArrayList<Integer> nindex = new ArrayList<Integer>();
			for(int a = 0; a < m; a++)
			{
				mindex.add(0);
			}
			for(int a = 0; a < n; a++)
			{
				nindex.add(0);
			}
			ArrayList<Integer> output = new ArrayList<Integer>();
			for(int a = 0; a < n; a++)
			{
				output.add(-1);
			}
			int firstchoice = mpref.get(q.peek()).get(mindex.get(q.peek()));
			output.set(firstchoice, q.peek());
			mindex.set(q.peek(), mindex.get(q.peek()) + 1);
			q.remove();
			
			
			while(!q.isEmpty())
			{
				//output.get(pref)
				int currentnanny, newnanny, pref;
				pref = mpref.get(q.peek()).get(mindex.get(q.peek()));
				if(output.get(pref).intValue() < 0)
				{
					output.set(pref, q.peek());
					mindex.set(q.peek(), mindex.get(q.peek()) + 1);
					q.remove();
				}
				else
				{
					currentnanny = findRank(npref.get(pref), output.get(pref).intValue());
					newnanny = findRank(npref.get(pref), q.peek().intValue());
					if(newnanny < currentnanny)
					{
						q.add(output.get(pref).intValue());
						output.set(pref, q.peek());
						mindex.set(q.peek(), mindex.get(q.peek()) + 1);
						q.remove();
					}
					else
					{
						mindex.set(q.peek(), mindex.get(q.peek()) + 1);
						continue;
					}
				}
				
			}
			
			System.out.println(output.toString().replace("[", "").replace("]", "").replace(",", ""));
			//System.out.println("hello");
		} finally {
			if(lists != null)
			{
				lists.close();
			}
		}

	}

	private static int findRank(ArrayList<Integer> npref, Integer nanny) {
		// TODO Auto-generated method stub
		
		int index = 0;
		for(int a = 0;  a < npref.size(); a++)
		{
			if(npref.get(a) == nanny)
			{
				index = a;
			}
		}
		return index;
		//return 0;
	}



}
