package org.example;

import java.awt.image.SampleModel;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
/*

interface Fly {
  default public void takeOff(){
    System.out.println("Fly::takeOff");
  }
  default public void turn(){
    System.out.println("Fly::turn");
  }
  default public void cruise(){
    System.out.println("Fly::cruise");
  }
  default public void land(){
    System.out.println("Fly::land");
  }
}

interface FastFly extends Fly {
  default public void takeOff(){
    System.out.println("FastFly::takeOff");
  }
}

class Vehicle {
  public void land(){
    System.out.println(   "Vehicle::land");
  }
}
interface Sail {
  default public void cruise (){
    System.out.println("Sail::Cruise");
  }
}

class SeaPlane extends Vehicle implements FastFly, Sail{
  public void cruise (){
    System.out.println("SeaPlane::cruise");
    Sail.super.cruise();
  }
}
*/

public class App {
/*
  public void use (){
    SeaPlane seaPlane = new SeaPlane();
    seaPlane.takeOff();
    seaPlane.cruise();
    seaPlane.turn();
    seaPlane.land();
  }
*/
  public static void main(String[] args) {
    //System.out.println("Hello World!");
    //List<Integer> values = List.of(1,2,3,4,5,6);
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
//    new App().use();

    //List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
    //System.out.println(total(values, e ->true));
    //System.out.println(total(values, e ->e%2==0));
    //System.out.println(total(values, e ->e%2!=0));
    /*System.out.println(totalEvenValues(values));
    System.out.println(totalOddValues(values));

    System.out.println(values.stream().reduce(0,(c,e)->c+e));
    System.out.println(values.stream().filter(i->i%2==0).reduce(0,(c,e)->c+e));
    System.out.println(values.stream().filter(i->i%2!=0).reduce(0,(c,e)->c+e));*/
    /*int result = 0;
    for (var i:values   ) {
      if(i>3 && i%2==0){
        result = i*2;
        break;
      }
    }
    System.out.println(result);

    System.out.println(values.stream().filter(i->i>3).filter(i -> i%2==0).map(i -> i*2).findFirst().orElse(0));
    System.out.println(values.stream().filter(App::isGt3).filter(App::isEven).map(App::doubleIt).findFirst().orElse(0));
    System.out.println("Here");*/
    //createPeople().stream().filter(p->p.getAge()>30).forEach(System.out::println);
    //createPeople().stream().map(Person::getName).forEach(System.out::println);
    //System.out.println( createPeople().stream().map(Person::getAge).reduce(0,(total,age)->total+age));
    //System.out.println(createPeople().stream().map(Person::getAge).reduce(0,(total,age)->Integer.sum(total,age)));
    //System.out.println(createPeople().stream().map(Person::getAge).reduce(0,Integer::sum));
    //List<String> listofPeopleGt30 = new ArrayList<>();

    //createPeople().stream().filter(person -> person.getAge()>30).map(p->p.getName()).map(String::toUpperCase).forEach(name->listofPeopleGt30.add(name));
    //listofPeopleGt30=createPeople().stream().filter(p->p.getAge()>30).map(Person::getName).map(String::toUpperCase).reduce(new ArrayList<String>(),(names,name)->{names.add(name);return names;},(names1,names2)->{names1.addAll(names2); return names1;});
    //listofPeopleGt30 = createPeople().stream().filter(p->p.getAge()>30).map(Person::getName).map(String::toUpperCase).collect(toList());
    //listofPeopleGt30 = createPeople().parallelStream().filter(p->p.getAge()>30).map(Person::getName).map(String::toUpperCase).collect(toList());
    //System.out.println(listofPeopleGt30);

    //System.out.println(createPeople().stream().collect(toMap(p->p.getName(),p->p.getAge())));
    //System.out.println(createPeople().stream().collect(toMap(Person::getName,Person::getAge)));
    //List<Integer> ages = createPeople().stream().map(Person::getAge).collect(toList());
    /*List<Integer> ages = createPeople().stream().map(Person::getAge).collect(toUnmodifiableList());
    ages.add(9);
    System.out.println(ages);
    System.out.println(ages.getClass());*/
    //System.out.println(createPeople().stream().map(Person::getName).map(String::toUpperCase).collect(joining(", ")));
    List<Person> people = createPeople();
    /*
    List<Person> evenAged = people.stream().filter(p->p.getAge()%2==0).collect(toList());
    List<Person> oddAged = people.stream().filter(p->p.getAge()%2!=0).collect(toList());
    System.out.println(evenAged);
    System.out.println(oddAged);*/

    //System.out.println(people.stream().collect(partitioningBy(p->p.getAge()%2==0)));

    // group the people based on their name  imperative way
    /*Map<String, List<Person>> byName =  new HashMap<>();
    for (Person p: people  ) {
      List<Person> list = null;
      if(byName.containsKey(p.getName())){
        list = byName.get(p.getName());
      } else {
        list = new ArrayList<>();
        byName.put(p.getName(),list);
      }
      list.add(p);
    }

    System.out.println(byName);*/

    // grouping by name - functional way
    //System.out.println(people.stream().collect(groupingBy(p->p.getName())));

    // grouping by name - functional way

    //System.out.println(people.stream().collect(groupingBy(p->p.getAge())))  ;

    Map<String, List<Integer>> ageByName = people.stream().collect(groupingBy(Person::getName, mapping(Person::getAge,toList())));
    System.out.println(ageByName);
    Map<String,Long> countByNameLong = people.stream().collect(groupingBy(Person::getName,counting()));
    System.out.println(countByNameLong);

    //Map<String, Integer> countByNameInteger = people.stream().collect(groupingBy(Person::getName,collectingAndThen(counting(),value->value.intValue())));
    Map<String,Integer> countByNameInteger = people.stream().collect(groupingBy(Person::getName,collectingAndThen(counting(),Long::intValue)));
    System.out.println(countByNameInteger);

    System.out.println(people.stream().mapToInt(Person::getAge).sum());
    System.out.println(people.stream().mapToInt(Person::getAge).max().orElse(-1));
    System.out.println(people.stream().mapToInt(Person::getAge).min().orElse(-1));

    System.out.println(people.stream().collect(maxBy(Comparator.comparing(Person::getAge))));
    System.out.println(people.stream().collect(minBy(Comparator.comparing(Person::getAge))));

    String result = people.stream().collect(collectingAndThen(maxBy(Comparator.comparing(Person::getAge)),
                        person->person.map(Person::getName).orElse("")));
    System.out.println(result);

    System.out.println(people.stream().collect(groupingBy(Person::getAge,mapping(Person::getName,toList()))));

    System.out.println(people.stream().collect(groupingBy(Person::getAge,mapping(Person::getName,filtering(name->name.length()>4,toList())))));

    // grouping mapping (Function, collector)
    // collectingAndThen  (Collector , function)
    // teeing  (collector, collector, operation)

    List<Integer> numbers = List.of(1,2,3);

    // one-to-one function
    System.out.println(numbers.stream().map(e->e*2)  // one to one function
            .collect(toList())  );  // Stream<T>.map(f11) ==> Stream<R>

    // one to many function
    System.out.println(numbers.stream().map(e->List.of(e-1,e+1))  // one to many function
         .collect(toList()) );

    System.out.println(numbers.stream().map(e->List.of(e-1,e+1))  // one to many function
            .collect(toSet()) );
    // Stream<T>.map(1n) ==> Stream<List<R>>  `

    // one to many function
    System.out.println(numbers.stream().flatMap(e->List.of(e-1,e+1).stream()    )  // one to many function
            .collect(toList()) );

    System.out.println(numbers.stream().flatMap(e->List.of(e-1,e+1).stream()    )  // one to many function
            .collect(toSet()) );
    // Stream<T>.flatMap(1n) ==> Stream<R>  `

    System.out.println(people.stream().map(Person::getName).flatMap(name-> Stream.of(name.split("")))
                        .collect(toList()));

    System.out.println(people.stream().collect(groupingBy(Person::getAge,
                          mapping(Person::getName, toList()))));
    System.out.println(people.stream().collect(groupingBy(Person::getAge,
                        flatMapping(person -> Stream.of(person.getName().split("")),toList()))));

    System.out.println(people.stream().collect(groupingBy(Person::getAge,
            flatMapping(person -> Stream.of(person.getName().split("")),toSet()))));

    System.out.println(people.stream()
            .collect(groupingBy(Person::getAge,
            mapping(person->person.getName().toUpperCase(),
            flatMapping(name-> Stream.of(name.split("")),toList())))));

    System.out.println(people.stream()
            .collect(groupingBy(Person::getAge,
                    mapping(person->person.getName().toUpperCase(),
                            flatMapping(name-> Stream.of(name.split("")),toSet())))));

    // reduce  - sum, min, max , reduce , collect

    // collect(Collector)

    // Collectors

    // toList, toSet, toMap
    // toUnmodifiableList, toUnmodifiableMap, toUnmodifiableSet

    // partitioning by

    // groupingBy

    // groupingBy(Function<T,R>)

    // groupingBy(function,collector)
    // mapping(function,collector)

    // collectingAndThen(collector, function)

    // teeing (collector, collector, operator)

    // Exception handling is imperative style of programming

    // In functional programming we deal with stream of data  - data flow

    // if you have a one to one function , use map to go from Stream<T> to Stream<R>

    // if you have a one to many function, use map to go from Stream<T> to Stream<Collection<R>>

    // if you have one to many function, use flatMap to go from Stream<T> to Stream<R>

    System.out.println("Sorted by name");
    people.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);

    System.out.println("Sorted by age");
    people.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
  }

  public static List<Person> createPeople(){
    return List.of(
            new Person("Sara", 20),
            new Person("Sara", 22),
            new Person("Bob", 20),
            new Person("Paula", 32),
            new Person("Paul",32),
            new Person("Jack",3),
            new Person("Jack",72),
            new Person("Jill",11)
            );
  }
  public static void findImperative(List<String> symbols){
    List<org.example.StockInfo> stocks = new ArrayList<>();
    for (String symbol: symbols ) {
      
    }
  }

  public static boolean isEven(int number){
    System.out.println("Is even for "+number);
    return number%2==0;
  }

  public static boolean isGt3(int number){
    System.out.println("Is GT3 for "+number);
    return number>3;
  }

  public static int doubleIt(int number){
    System.out.println("double It for "+number);
    return number*2;
  }
  public static int total(List<Integer> numbers, Predicate<Integer> selector){
    return numbers.stream().filter(selector).reduce(0,(c,e)->c+e);
    /*int total =0;
    for (var i:numbers    ) {
      if(selector.test(i))
      total += i;
    }
    return total;*/
  }
  public static int totalEvenValues(List<Integer> numbers){
    int total =0;
    for (var i:numbers    ) {
      if(i%2==0)
      total += i;
    }
    return total;
  }
  public static int totalOddValues(List<Integer> numbers){
    int total =0;
    for (var i:numbers    ) {
      if(i%2!=0)
        total += i;
    }
    return total;
  }

}
