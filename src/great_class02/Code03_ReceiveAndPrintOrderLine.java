package great_class02;

import java.util.HashMap;
import java.util.Map;

public class Code03_ReceiveAndPrintOrderLine {

	public static class Node {
		public String info;
		public Node next;

		public Node(String str) {
			info = str;
		}
	}

	public static class MessageBox {
		private Map<Integer, Node> tailMap;
		private Map<Integer, Node> headMap;
		private int waitPoint;

		public MessageBox(){
			tailMap = new HashMap<>();
			headMap = new HashMap<>();
			waitPoint = 1;
		}

		public void receive(int num, String info) {
			if (num < 1) {
				return;
			}
			Node cur = new Node(info);
			headMap.put(num, cur);
			tailMap.put(num, cur);
			if (tailMap.containsKey(num - 1)) {
				tailMap.get(num - 1).next = cur;
				tailMap.remove(num - 1);
				headMap.remove(num);
			}
			if (headMap.containsKey(num + 1)) {
				cur.next = headMap.get(num + 1);
				headMap.remove(num + 1);
				tailMap.remove(num);
			}
			if(num == waitPoint){
				Node node = headMap.get(num);
				headMap.remove(num);
				while(node != null){
					System.out.print(node.info + " ");
					node = node.next;
					waitPoint++;
				}
				tailMap.remove(waitPoint - 1);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// MessageBox only receive 1~N
		MessageBox box = new MessageBox();
		// 1....
		System.out.println("这是2来到的时候");
		box.receive(2,"B"); // - 2"
		System.out.println("这是1来到的时候");
		box.receive(1,"A"); // 1 2 -> print, trigger is 1
		box.receive(4,"D"); // - 4
		box.receive(5,"E"); // - 4 5
		box.receive(7,"G"); // - 4 5 - 7
		box.receive(8,"H"); // - 4 5 - 7 8
		box.receive(6,"F"); // - 4 5 6 7 8
		box.receive(3,"C"); // 3 4 5 6 7 8 -> print, trigger is 3
		box.receive(9,"I"); // 9 -> print, trigger is 9
		box.receive(10,"J"); // 10 -> print, trigger is 10
		box.receive(12,"L"); // - 12
		box.receive(13,"M"); // - 12 13
		box.receive(11,"K"); // 11 12 13 -> print, trigger is 11

	}
}
