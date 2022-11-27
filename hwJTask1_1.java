package javahw4;
import java.util.*;
public class hwJTask1_1 {
    public static void main(String[] args) {
        hwJTask1_1 tk = new hwJTask1_1();
        String deckOne = "1 3 5 7 9";
        String deckTwo = "2 4 6 8 0";
        tk.whoIsWinner(deckOne,deckTwo);
    }

    public void whoIsWinner(String someDeckOne, String someDeckTwo) {
        Deque<String> queueDeckOneString = new ArrayDeque<>(Arrays.asList(someDeckOne.split(" ")));
        Deque<String> queueDeckTwoString = new ArrayDeque<>(Arrays.asList(someDeckTwo.split(" ")));
        Deque<Integer> queueDeckOneInteger = new ArrayDeque<>();
        Deque<Integer> queueDeckTwoInteger = new ArrayDeque<>();
        while (!queueDeckTwoString.isEmpty()) {
            queueDeckOneInteger.add(Integer.valueOf(queueDeckOneString.poll()));
            queueDeckTwoInteger.add(Integer.valueOf(queueDeckTwoString.poll()));
        }
        Integer cardOne, cardTwo,counter = 0;
        while (!queueDeckOneInteger.isEmpty() && !queueDeckTwoInteger.isEmpty()  && !counter.equals(100000)) {
            cardOne = queueDeckOneInteger.pollFirst();
            cardTwo = queueDeckTwoInteger.pollFirst();
            if (cardOne.equals(0) && cardTwo.equals(9)) {
                queueDeckOneInteger.addLast(0);
                queueDeckOneInteger.addLast(9);
            } else if (cardOne.equals(9) && cardTwo.equals(0)) {
                queueDeckTwoInteger.addLast(0);
                queueDeckTwoInteger.addLast(9);
            } else if (cardOne > cardTwo) {
                queueDeckOneInteger.addLast(cardOne);
                queueDeckOneInteger.addLast(cardTwo);
            } else {
                queueDeckTwoInteger.addLast(cardTwo);
                queueDeckTwoInteger.addLast(cardOne);
            }
            counter++;
        }
        if(queueDeckOneInteger.isEmpty()){
            System.out.println(String.format("second %d",counter));
        }else if(queueDeckTwoInteger.isEmpty()){
            System.out.println(String.format("first %d",counter));
        }else{
            System.out.println("botva");
        }
    }
}
