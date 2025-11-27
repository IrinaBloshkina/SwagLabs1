package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("swaglab.user"),
                PropertyReader.getProperty("swaglab.password"));
    }

    public static User withLockedUserPermission() {
        return new User(PropertyReader.getProperty("swaglab.locked_user"),
                PropertyReader.getProperty("swaglab.password"));
    }

    public static User withPerfGlitchUserPermission() {
        return new User(PropertyReader.getProperty("swaglab.perf_user"),
                PropertyReader.getProperty("swaglab.password"));
    }
}
