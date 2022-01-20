package com.example.simulation;

import com.example.simulation.models.*;
import com.example.simulation.repositories.ReceiptRepository;
import com.example.simulation.repositories.SalesRepository;
import com.example.simulation.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
@RestController
public class SimulationApplication {

	@Autowired
	private ReceiptRepository repo;

	@Autowired
	private SalesRepository salesRepository;

	public static void main(String[] args) {
		SpringApplication.run(SimulationApplication.class, args);
	}

	@RequestMapping(path = "/getConversationList")
	public ConversationList returnConversationList(ConversationListService service){
		return service.getConversationList();
	}

	@RequestMapping(path = "/getFullAddress")
	public FullAddress returnFullAddress(FullAddressService service){
		return service.getFullAddress("31160550");
	}

	@RequestMapping(path = "/sendMessage")
	public List<SendMessage> sendResponse(SendMessageService service){
		List<SendMessage> sentMessages = new ArrayList<>();
		ConversationListService conversationListService = new ConversationListService();
		ConversationsService conversationsService = new ConversationsService();
		int listNumber = conversationListService.getConversationList().getConversationIds().size();
		for (int i=0; i<listNumber; i++){
			String conversation_id = conversationListService.getConversationList().getConversationIds().get(i).toString();
			String subject = conversationsService.getConversation(conversation_id).getSubject();
			switch (subject){
				case "bank account receipt problem":
					sentMessages.add(service.sendResponseMessage(returnResponseMessage(conversationsService, conversation_id)));
					break;
				case "connection problem":
					sentMessages.add(service.sendResponseMessage(returnResponseMessage2(conversationsService, conversation_id)));
					break;
				case "late delivery":
					sentMessages.add(service.sendResponseMessage(returnResponseMessage3(conversationsService, conversation_id)));
					break;
				case "check delivery address":
					sentMessages.add(service.sendResponseMessage(returnResponseMessage4(conversationsService, conversation_id)));
					break;
				case "delivery forecast":
					sentMessages.add(service.sendResponseMessage(returnResponseMessage5(conversationsService, conversation_id)));
					break;
			}
		}
		return sentMessages;
	}

	public Map<String, String> returnResponseMessage(ConversationsService service, String conversation_id){
		int merchant_id = Integer.parseInt(service.getConversation(conversation_id).getMerchantId());
		String reason = repo.findByMerchantId(merchant_id).getDescription();
		String message = "Hi. You have not received your funds due to the reason "+reason+" meaning that the bank's services are currently down.";
		Map<String, String> map = new HashMap<String, String>();
		map.put("conversation_id", conversation_id);
		map.put("message", message);
		return map;
	}

	public Map<String, String> returnResponseMessage2(ConversationsService service, String conversation_id){
		int merchant_id = Integer.parseInt(service.getConversation(conversation_id).getMerchantId());
		String chip_id = salesRepository.findByMerchantId(merchant_id).getChip_id();
		ChipService chipService = new ChipService();
		String status = chipService.getChipDetails(chip_id).getStatus();
		String reason = chipService.getChipDetails(chip_id).getDescription();
		String message = "Hi. Your chip is not connected to the internet because status is "+status+" with the reason being that the "+reason;
		Map<String, String> map = new HashMap<String, String>();
		map.put("conversation_id", conversation_id);
		map.put("message", message);
		return map;
	}
	public Map<String, String> returnResponseMessage3(ConversationsService service, String conversation_id){
		int merchant_id = Integer.parseInt(service.getConversation(conversation_id).getMerchantId());
		String id_sale = String.valueOf(salesRepository.findByMerchantId(merchant_id).getId_sale());
		DeliveryStatusService deliveryStatusService = new DeliveryStatusService();
		String date = deliveryStatusService.getDeliveryStatus(id_sale).getDeliveryForecast();
		String status = deliveryStatusService.getDeliveryStatus(id_sale).getStatus();
		String message = "Hi. Your delivery is currently "+status+" and is scheduled to arrive on "+date+". We apologize for any inconveniences.";
		Map<String, String> map = new HashMap<String, String>();
		map.put("conversation_id", conversation_id);
		map.put("message", message);
		return map;
	}
	public Map<String, String> returnResponseMessage4(ConversationsService service, String conversation_id){
		int merchant_id = Integer.parseInt(service.getConversation(conversation_id).getMerchantId());
		String id_sale = String.valueOf(salesRepository.findByMerchantId(merchant_id).getId_sale());
		DeliveryStatusService deliveryStatusService = new DeliveryStatusService();
		String date = deliveryStatusService.getDeliveryStatus(id_sale).getDeliveryForecast();
		String message = "Hi. Your delivery is scheduled to arrive on "+date+".";
		Map<String, String> map = new HashMap<String, String>();
		map.put("conversation_id", conversation_id);
		map.put("message", message);
		return map;
	}
	public Map<String, String> returnResponseMessage5(ConversationsService service, String conversation_id){
		int merchant_id = Integer.parseInt(service.getConversation(conversation_id).getMerchantId());
		String id_sale = String.valueOf(salesRepository.findByMerchantId(merchant_id).getId_sale());
		DeliveryStatusService deliveryStatusService = new DeliveryStatusService();
		String zip_code = deliveryStatusService.getDeliveryStatus(id_sale).getDestinationZipCode();
		Map<String, String> map = new HashMap<String, String>();
		map.put("conversation_id", conversation_id);
		try {
			FullAddressService fullAddressService = new FullAddressService();
			String fullAddress = fullAddressService.getFullAddress(zip_code).toString();
			String message = "Hi. Your delivery will be delivered to the following address: "+fullAddress;
			map.put("message", message);
		}
		catch (Exception e){
			e.printStackTrace();
			map.put("message", "Hi. The delivery address cannot be found.");
		}
		return map;
	}

}
