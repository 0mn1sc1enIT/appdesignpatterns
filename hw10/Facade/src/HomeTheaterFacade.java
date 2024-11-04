public class HomeTheaterFacade {
    private TV tv;
    private AudioSystem audioSystem;
    private DVDPlayer dvdPlayer;
    private GameConsole gameConsole;

    public HomeTheaterFacade(TV tv, AudioSystem audioSystem, DVDPlayer dvdPlayer, GameConsole gameConsole) {
        this.tv = tv;
        this.audioSystem = audioSystem;
        this.dvdPlayer = dvdPlayer;
        this.gameConsole = gameConsole;
    }

    public void StartMovie() {
        System.out.println("Preparing to start the movie...");
        tv.TurnOn();
        audioSystem.turnOn();
        audioSystem.setVolume(8);
        dvdPlayer.Play();
        System.out.println("Movie started!");
    }
    public void EndMovie() {
        System.out.println("Shutting down movie...");
        tv.TurnOff();
        audioSystem.turnOff();
        dvdPlayer.Stop();
        System.out.println("Movie ended.");
    }

    public void StartGame() {
        System.out.println("Starting the game...");
        gameConsole.TurnOn();
        gameConsole.Game("Tekken 6");
        System.out.println("Enjoy the game!");
    }

    public void StartMusicSystem() {
        System.out.println("Preparing music system...");
        tv.TurnOn();
        audioSystem.turnOn();
        audioSystem.setVolume(5);
        System.out.println("Music system is ready!");
    }
}
