package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- 猫狗队列
 * @version 2017/08/25 09:15
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.*;

/**
 * 题目：实现一种猫狗队列的数据结构
 *
 * 要求：
 * 1、add 方法可以加入cat 和 dog
 * 2、pollAll 方法可以按照所有实例的先后顺序弹出
 * 3、pllDog 方法将dog 实例按照先后顺序弹出
 * 4、pllCat 方法将cat 实例按照先后顺序弹出
 * 5、isEmpty 方法判断是否有实例
 * 6、isDogEmpty 方法判断是否有dog实例
 * 7、isCatEmpty 方法判断是否有cat实例
 *
 * 难度：￥
 *
 * 思路：
 * 1、使用一个类继承自列表，类内包含两个队列
 * 2、给每个元素打上时间标签，使用猫狗两个队列
 *
 * 用时：36分钟
 */

public class _4_CatDogQueue {

    public static void main(String[] args){

        CatDogQueue1 catDogQueue = new CatDogQueue1();

        catDogQueue.add(new Cat());
        catDogQueue.add(new Dog());
        catDogQueue.add(new Cat());
        catDogQueue.add(new Cat());

        while (!catDogQueue.isDogEmpty()){
            System.out.println(catDogQueue.pollDog().getPetType());
        }

        while (!catDogQueue.isCatEmpty()){
            System.out.println(catDogQueue.pollCat().getPetType());
        }
    }

}

class Pet{
    private String type;

    public Pet(String type){
        this.type = type;
    }

    public String getPetType(){
        return this.type;
    }
}

class Dog extends Pet{
    public Dog(){
        super("dog");
    }
}

class Cat extends Pet{
    public Cat(){
        super("cat");
    }
}

class CatDogQueue1 extends ArrayList<Pet> {

    private Queue<Pet> DogQueue = new LinkedList<>();
    private Queue<Pet> CatQueue = new LinkedList<>();

    public boolean add(Pet pet){
        if(Objects.equals(pet.getPetType(), "cat"))
            CatQueue.add(pet);
        else
            DogQueue.add(pet);
        return super.add(pet);
    }

    public Pet pollAll(){
        if(Objects.equals(super.remove(0).getPetType(), "cat"))
            return CatQueue.poll();
        else
            return DogQueue.poll();
    }

    public Pet pollCat(){
        remove(CatQueue.peek());
        return CatQueue.poll();
    }

    public Pet pollDog(){
        remove(DogQueue.peek());
        return DogQueue.poll();
    }

    public boolean isEmpty(){
        return (CatQueue.isEmpty() && DogQueue.isEmpty());
    }

    public boolean isDogEmpty(){
        return DogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return CatQueue.isEmpty();
    }
}

class PetEnterQueue{
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet,long count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet(){
        return this.pet;
    }

    public long getCount(){
        return this.count;
    }

    public String getEnterPetType(){
        return this.pet.getPetType();
    }
}

class CatDogQueue2{
    private Queue<PetEnterQueue> CatQueue;
    private Queue<PetEnterQueue> DogQueue;
    private long count;

    public CatDogQueue2(){
        this.CatQueue = new LinkedList<>();
        this.DogQueue = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet){
        if(pet.getPetType() == "cat")
            CatQueue.add(new PetEnterQueue(pet,count++));
        else
            DogQueue.add(new PetEnterQueue(pet,count++));
    }

    public Pet pollAll(){
        if(CatQueue.peek().getCount() > DogQueue.peek().getCount())
            return CatQueue.poll().getPet();
        else
            return DogQueue.poll().getPet();
    }

    public Pet pollCat(){
        return CatQueue.poll().getPet();
    }

    public Pet pollDog(){
        return DogQueue.poll().getPet();
    }

    public boolean isEmpty(){
        return (CatQueue.isEmpty() && DogQueue.isEmpty());
    }

    public boolean isDogEmpty(){
        return DogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return CatQueue.isEmpty();
    }
}