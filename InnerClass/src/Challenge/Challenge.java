package Challenge;

import java.util.*;

public class Challenge {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.2);
        album.addSong("Holy man", 4.1);
        album.addSong("Hold on", 3.6);
        album.addSong("Lady double dealer", 3.8);
        album.addSong("You can't do it right", 3.5);
        album.addSong("High ball shooter", 5.6);
        album.addSong("The gypsy", 3.6);
        album.addSong("Solder of fortune", 2.6);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 4.5);
        album.addSong("I put the finger on you", 4.6);
        album.addSong("Let's go", 4.4);
        album.addSong("Inject the venom", 4.2);
        album.addSong("Snowballed", 4.1);
        album.addSong("Evil walks", 4.8);
        album.addSong("C.O.D.", 3.6);
        album.addSong("Breaking the rules", 2.6);
        album.addSong("Night of the long knives", 3.8);

        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(29, playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playlist) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No songs on the playlist");
            return;
        } else {
            System.out.printf("Now playing %s\n", listIterator.next().toString());
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.printf("Quitting");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.printf("Now playing: %s\n", listIterator.next().toString());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.printf("Now playing: %s\n", listIterator.previous().toString());
                    } else {
                        System.out.println("We are on the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying: " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are on the start of the playlist");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying: " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("Reached the end of the playlist");
                        }
                    }
                    break;
                case 4:
                    if (playlist.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying: " + listIterator.next().toString());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying: " + listIterator.previous().toString());
                        }
                    } else {
                        System.out.println("The playlist is empty");
                    }
                    break;
                case 5:
                    printList(playlist);
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Avaible actions: \nPress ");
        System.out.println("0 - to quit\n" +
                "1 - go to the next song\n" +
                "2 - go to the previous song\n" +
                "3 - to replay the current song\n" +
                "4 - to remove song from the playlist\n" +
                "5 - list songs on the playlist\n" +
                "6 - print the menu again");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }
}
