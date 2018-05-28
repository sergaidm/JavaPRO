package ru.yandex.sergaidm;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class JSONMessageWorker implements JsonSerializer<Message>, JsonDeserializer<Message> {

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");

	@Override
	public Message deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject jsonObject = arg0.getAsJsonObject();
		String from = jsonObject.get("from").getAsString();
		String to = jsonObject.get("to").getAsString();
		String text = jsonObject.get("text").getAsString();
		TemporalAccessor ta = LocalDateTime.parse(jsonObject.get("sending date").getAsString(), dtf);
		LocalDateTime sendingDate = LocalDateTime.from(ta);
		return new Message(from, to, text, sendingDate);
	}

	@Override
	public JsonElement serialize(Message arg0, Type arg1, JsonSerializationContext arg2) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("from", arg0.getFrom());
		jsonObject.addProperty("to", arg0.getTo());
		jsonObject.addProperty("text", arg0.getText());
		jsonObject.addProperty("sending date", dtf.format(arg0.getSendingDate()));
		return jsonObject;
	}

}
