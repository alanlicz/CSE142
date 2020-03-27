// Alan Li  
// 01/19/2020
// CSE142
// TA: Eric Koegler
// Assignment #1
//
// This program will out put a song which has six verse including one custom verse

public class Song {

    public static void main(String[] args) {
        firstVerse();
        secondVerse();
        thirdVerse();
        fourthVerse();
        fifthVerse();
        sixthVerse();
        seventhVerse();
    }

    public static void sheWillDie(){
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");
    }

    public static void swallowTheSpider(){
        System.out.println("She swallowed the spider to catch the fly,");
        sheWillDie();
    }

    public static void swallowTheBird(){
        System.out.println("She swallowed the bird to catch the spider,");
        swallowTheSpider();
    }

    public static void swallowTheCat(){
        System.out.println("She swallowed the cat to catch the bird,");
        swallowTheBird();
    }

    public static void swallowTheDog(){
        System.out.println("She swallowed the dog to catch the cat,");
        swallowTheCat();
    }

    public static void swallowTheWolf(){
        System.out.println("She swallowed the wolf to catch the dog,");
        swallowTheDog();
    }

    public static void firstVerse(){
        System.out.println("There was an old woman who swallowed a fly.");
        sheWillDie();
        System.out.println();
    }

    public static void secondVerse(){
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        swallowTheSpider();
        System.out.println();
    }

    public static void thirdVerse(){
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        swallowTheBird();
        System.out.println();
    }

    public static void fourthVerse(){
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        swallowTheCat();
        System.out.println();
    }

    public static void fifthVerse(){
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        swallowTheDog();
        System.out.println();
    }

    public static void sixthVerse(){
        System.out.println("There was an old woman who swallowed a wolf,");
        System.out.println("It takes a while to swallow a wolf.");
        swallowTheWolf();
        System.out.println();

    }

    public static void seventhVerse(){
        System.out.println("There was an old woman who swallowed a horse,");
        System.out.println("She died of course.");
    }



}