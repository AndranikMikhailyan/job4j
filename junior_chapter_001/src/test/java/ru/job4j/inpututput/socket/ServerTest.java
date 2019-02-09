package ru.job4j.inpututput.socket;

import com.google.common.base.Joiner;
import org.junit.Test;
import ru.job4j.inpututput.socket.server.Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    private static final String LN = System.lineSeparator();

    private void serverTest(String input, String excepted) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(excepted));
    }

    @Test
    public void whenAskByeThen() throws IOException {
        this.serverTest("пока", "");
    }

    @Test
    public void whenAskHelloThen() throws IOException {
        this.serverTest(
                Joiner.on(LN).join(
                        "Привет",
                        "пока"
                ),
                Joiner.on(LN).join(
                        "Привет, дорогой друг, я oracle.",
                        "",
                        ""
                ));
    }

    @Test
    public void whenAskAnyThen() throws IOException {
        this.serverTest(
                Joiner.on(LN).join(
                        "Неизвестно",
                        "пока"
                ),
                Joiner.on(LN).join(
                        "Ок!",
                        "",
                        ""
                ));
    }
}
