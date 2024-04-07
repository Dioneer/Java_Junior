package Pegas.Seminar3.task2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;

@Getter
@ToString
public class ToDo implements Externalizable {
    private String title;
    @Setter
    private boolean isDone;

    public ToDo() {
    }

    public ToDo(String title) {
        this.title = title;
        this.isDone = false;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeBoolean(isDone);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        isDone = in.readBoolean();
    }
}
