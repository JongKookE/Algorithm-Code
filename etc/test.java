package etc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class test {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < 100; i++) stack.add(i);
		for(Integer integer: stack) System.out.println(integer);
		System.out.println(stack.get(10));

//		Queue<Integer> stack = new ArrayDeque<>();
//		for(int i = 0; i < 100; i++) stack.add(i);
//		for(Integer integer: stack) System.out.println(integer);
//
//		Deque<Integer> dq = new ArrayDeque<>();
//		for(Integer integer: dq) System.out.println(integer);
//		System.out.println(dq.get);

	}

}
