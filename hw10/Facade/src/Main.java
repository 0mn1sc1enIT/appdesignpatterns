public class Main {
    public static void main(String[] args) {
        AudioSystem audio = new AudioSystem();
        TV tv = new TV();
        DVDPlayer dvdPlayer = new DVDPlayer();
        GameConsole gameConsole = new GameConsole();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, audio, dvdPlayer, gameConsole);

        homeTheater.StartMovie();

        System.out.println();

        homeTheater.EndMovie();

        System.out.println();

        homeTheater.StartGame();

        System.out.println();

        homeTheater.StartMusicSystem();
    }

}
