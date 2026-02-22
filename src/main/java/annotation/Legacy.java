package annotation;

class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature - avoid using");
    }

    public void newFeature() {
        System.out.println("New feature - recommended");
    }
}

public class Legacy {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
