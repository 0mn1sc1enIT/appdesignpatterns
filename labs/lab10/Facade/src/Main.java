public class Main {
    public static void main(String[] args) {
        AudioSystem audio = new AudioSystem();
        VideoProjector video = new VideoProjector();
        LightingSystem lights = new LightingSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(audio, video, lights);

        homeTheater.startMovie();

        System.out.println();

        homeTheater.endMovie();
    }
}
