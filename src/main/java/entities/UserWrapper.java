package entities;

public class UserWrapper {
    private User data;

    public UserWrapper(User data) {
        this.data = data;
    }

    public UserWrapper() {
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserWrapper{" +
                "user=" + data +
                '}';
    }
}
