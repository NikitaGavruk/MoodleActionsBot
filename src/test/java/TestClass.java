import org.junit.jupiter.api.Test;
import page.MoodlePage;

class TestClass {
    @Test
    void loginToMoodle() {
        new MoodlePage()
            .getMoodleSite()
            .loginToMoodle();
    }

}
