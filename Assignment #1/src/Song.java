// Alan Li  
// 01/19/2020
// CSE142
// TA: Eric Koegler
// Assignment #1
//
// This program will out put a song which has six verse including one custom verse

public class Song {
    public static void SheWillDie(){
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");
    }

    public static void SwallowTheSpider(){
        System.out.println("She swallowed the spider to catch the fly,");
    }

    public static void SwallowTheBird(){
        System.out.println("She swallowed the bird to catch the spider,");
    }

    public static void SwallowTheCat(){
        System.out.println("She swallowed the cat to catch the bird,");
    }

    public static void SwallowTheDog(){
        System.out.println("She swallowed the dog to catch the cat,");
    }

    public static void SwallowTheWolf(){
        System.out.println("She swallowed the wolf to catch the dog,");
    }

    public static void FirstVerse(){
        System.out.println("There was an old woman who swallowed a fly.");
        SheWillDie();
        System.out.println();
    }

    public static void SecondVerse(){
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        SwallowTheSpider();
        SheWillDie();
        System.out.println();
    }

    public static void ThirdVerse(){
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        SwallowTheBird();
        SwallowTheSpider();
        SheWillDie();
        System.out.println();
    }

    public static void FourthVerse(){
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        SwallowTheCat();
        SwallowTheBird();
        SwallowTheSpider();
        SheWillDie();
        System.out.println();
    }

    public static void FifthVerse(){
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        SwallowTheDog();
        SwallowTheCat();
        SwallowTheBird();
        SwallowTheSpider();
        SheWillDie();
        System.out.println();
    }

    public static void SixthVerse(){
        System.out.println("There was an old woman who swallowed a wolf,");
        System.out.println("It takes a while to swallow a wolf.");
        SwallowTheWolf();
        SwallowTheDog();
        SwallowTheCat();
        SwallowTheBird();
        SwallowTheSpider();
        SheWillDie();
        System.out.println();

    }

    public static void SeventhVerse(){
        System.out.println("There was an old woman who swallowed a horse,");
        System.out.println("She died of course.");
    }

    public static void main(String[] args) {
        FirstVerse();
        SecondVerse();
        ThirdVerse();
        FourthVerse();
        FifthVerse();
        SixthVerse();
        SeventhVerse();
    }

}