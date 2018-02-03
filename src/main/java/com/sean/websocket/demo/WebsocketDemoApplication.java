package com.sean.websocket.demo;

import com.sean.websocket.demo.snake.SnakeWebSocketHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@EnableWebSocket
public class WebsocketDemoApplication extends SpringBootServletInitializer implements
		WebSocketConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketDemoApplication.class, args);
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
		webSocketHandlerRegistry.addHandler(snakeWebSocketHandler(), "/snake").withSockJS();
	}
	@Bean
	public WebSocketHandler snakeWebSocketHandler() {
		return new PerConnectionWebSocketHandler(SnakeWebSocketHandler.class);
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

}
