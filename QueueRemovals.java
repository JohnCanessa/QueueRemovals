import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


/**
 * Queue Removals
 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=229890198389794
 */
public class QueueRemovals {


    /**
     * There must be a simpler way.
     */
    static int[] findPositions(int[] arr, int x) {

        // **** initialization ****
        ArrayList<Integer> ans  = new ArrayList<>();
        LinkedList<int[]> q     = new LinkedList<>();
        LinkedList<int[]> wq    = new LinkedList<>();

        // **** populate q ****
        for (int i = 0; i < arr.length; i++) {

            // **** value and position in arr ****
            int[] e = new int[] {arr[i], i};
            
            // **** append element to q ****
            q.addLast(e);
        }

        // **** loop the specified number of times ****
        for (int i = 0; i < x; i++) {

            // ???? ????
            System.out.println("<<< i: " + i);

            // **** [1] move x elements from q to wq ****
            int[] maxe = new int[] {-1, -1};
            for (int j = 0; j < x && !q.isEmpty(); j++) {

                // **** update max value and index ****
                if (q.peek()[0] > maxe[0]) {
                    maxe = q.peek();
                }

                // **** remove element from q and insert into wq ****
                wq.addLast(q.removeFirst());
            }

            // ???? ????
            System.out.println("<<< maxe: " + Arrays.toString(maxe));

            // **** [2] find element with largest value (done in [1]) and remove it ****
            wq.remove(maxe);

            // **** add index to array list ****
            ans.add(maxe[1] + 1);

            // ???? ????
            System.out.println("<<< ans: " + ans.toString());

            // **** [3] decrement values by 1 and add them back to the queue ****
            while (!wq.isEmpty()) {

                // **** remove head element ****
                int[] e = wq.removeFirst();

                // **** decrement value (if needed) ****
                if (e[0] > 0)
                    e[0]--;

                // **** append element to q ****
                q.addLast(e);
            }
        }

        // **** convert array list to int[] ****
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }


    /**
     * WORK IN PROGRESS - WORK IN PROGRESS - WORK IN PROGRESS
     */
    static int[] find(int[] arr, int x) {

        // **** initialization ****
        ArrayList<Integer> ans  = new ArrayList<>();
        Stack<Integer> stack    = new Stack<Integer>();

        // **** push all elements into the stack ****
        for (int i = arr.length - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }

        // **** iterate as needed ****
        for (int i = 0; i < x; i++) {

            // ???? ????
            System.out.println("<<< i: " + i);

            // **** loop decrementing entries ****
            for (int j = 0; j < stack.size() && j < x; j++) {
                int e = stack.elementAt(j);
                if (e > 0)
                    e--;
                stack.set(j, e);
            }

            // ???? ????
            System.out.println("<<< stack : " + stack.toString());




            // ???? ????
            System.out.println();
        }

        // **** convert array list to int[] ****
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }


    /**
     * Test scaffolding
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read the input line split values ****
        String[] strs = br.readLine().trim().split(",");

        // **** read x ****
        int x = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();

        // **** populate array of integer ****
        int[] arr = Arrays.stream(strs)
                        .mapToInt(Integer::parseInt)
                        .toArray();


        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));
        System.out.println("main <<<   x: " + x);

        // **** compute and display output ****
        System.out.println("main <<< output: " + Arrays.toString(findPositions(arr, x)));

        // **** compute and display output ****
        System.out.println("main <<< output: " + Arrays.toString(find(arr, x)));
    }
}