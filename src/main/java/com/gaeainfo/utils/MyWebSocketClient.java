package com.gaeainfo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Date;


/**
 * Created by Rock on 2017/3/14.
 */
public class MyWebSocketClient {


    private static final String WS_URI = "ws://58.211.58.110:12000";

    public static void main(String[] args) throws Exception {
        String uri = "ws://58.211.58.110:12000";

        Logger logger = LoggerFactory.getLogger(MyWebSocketClient.class);

        logger.info("start.................");
        StandardWebSocketClient client = new StandardWebSocketClient();
        WebSocketConnectionManager manager = new WebSocketConnectionManager(client, new MyHandler(), WS_URI);
        manager.start();
        while(true){
            Thread.sleep(30000);
            System.out.println("sleep again!");
        }

        /*WebSocketContainer container = ContainerProvider.getWebSocketContainer();

        Session session = container.connectToServer(Client.class, new URI(uri)); // 连接会话
        session.getBasicRemote().sendText("{\"type\":\"observer_login\",\"eid\":\"FY942AF0100001\"}"); // 发送文本消息
        System.out.println(session.getId());
        Thread.sleep(10000);*/
    }

    private static class MyHandler extends TextWebSocketHandler {

        public Logger logger = LoggerFactory.getLogger(this.getClass());
        private WebSocketSession session;
        private String id;

        public MyHandler() {
        }

        public MyHandler(String id) {
            this.id = id;
        }

        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            System.out.println("connected...........");
            //session.sendMessage(new TextMessage("hello, web socket"));
            this.session = session;
            //this.session.sendMessage(new TextMessage("{\"type\":\"observer_login\",\"eid\":\"FY942AF0100001\"}"));
            sendMessage("{\"type\":\"observer_login\",\"eid\":\"FY942AF0100001\"}");
            super.afterConnectionEstablished(session);
        }

        @Override
        protected void handleTextMessage(WebSocketSession session, TextMessage message)
                throws Exception {

            System.out.println("receive: "+new Date() + message.getPayload());
            String str = message.getPayload();
            if(str.indexOf("\"type\":\"ping\"")>0){
                sendMessage(str);
                System.out.println("send ping.....");
            }
            super.handleTextMessage(session, message);
        }

        public void sendMessage(String str) throws Exception{
            this.session.sendMessage(new TextMessage(str));
        }

        @Override
        public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
            System.out.println("connection closed..........."+status.getReason());
            super.afterConnectionClosed(session,status);
        }
    }
}
