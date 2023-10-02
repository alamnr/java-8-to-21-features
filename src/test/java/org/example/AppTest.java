package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Consumer;
public class AppTest {
    
  @Test
  public void shouldAnswerWithTrue() {

    //assertTrue(true);
    List<Integer> values = List.of(1,2,3,4,5,6);
    /*for (var i= 0;i< values.size();i++){
      System.out.println(values.get(i));
    }*/
    /*for (var i: values  ) {
      System.out.println(i);
    }*/
      /*values.forEach(new Consumer<Integer>() {
        @Override
        public void accept(Integer integer) {
          System.out.println(integer);
        }
      });*/
    //values.forEach((Integer i) -> System.out.println(i));
    //values.forEach(i-> System.out.println(i));
    //values.forEach(System.out::println);
      /*int total =0;
    for (int e : values       ) {
      total += e*2;
    }*/
    //System.out.println(total);

    //System.out.println(values.stream().map(e->e*2).reduce(0,(c,e)-> c+e));
  }
}
