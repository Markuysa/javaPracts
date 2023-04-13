package com.example.task11.Services;

import com.example.task11.Entities.Bank;
import com.example.task11.Entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.management.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
@MXBean
public class SchedulerService implements SchedulerServiceInterface{
    @Autowired
    private CardService cardService;

    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    public CardService getCardService() {
        return cardService;
    }

    public BankService getBankService() {
        return bankService;
    }

    public Path getCards() {
        return cards;
    }

    public Path getBanks() {
        return banks;
    }

    @Autowired
    private BankService bankService;
    private final Path cards = Path.of("C:\\outData\\cards.txt");
    private final Path banks = Path.of("C:\\outData\\banks.txt");
    public SchedulerService(){

    }
    @Scheduled(cron = "0 0/30 * * * ?")
    public void doScheduledTask() throws IOException {
        if(Files.exists(cards)) {
            Files.delete(cards);
        }
        if(Files.exists(banks)) {
            Files.delete(banks);
        }
        List<Bank> bankList = bankService.getAll();
        List<Card> cardList = cardService.getAll();

        StringBuilder cardsData = new StringBuilder();
        StringBuilder banksData = new StringBuilder();
        for(Bank b : bankList) {
            banksData.append(b.getId()).append(" ").append(b.getName()).append(" ").append(b.getAddress()).append("\n");
        }
        for(Card c : cardList) {
            cardsData.append(c.getId()).append(" ").append(c.getCode()).append(" ").append(c.getCardnumber()).append("\n");
        }
        FileWriter fileWriter = new FileWriter("C:\\outData\\cards.txt");
        fileWriter.write(cardsData.toString());
        fileWriter.close();

        FileWriter fileWriter1 = new FileWriter("C:\\outData\\banks.txt");
        fileWriter1.write(banksData.toString());
        fileWriter1.close();

    }

    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException, ReflectionException {
        switch(attribute) {
            case "cardService":
                return this.cardService;
            case "bankService":
                return this.bankService;
            default:
                throw new AttributeNotFoundException("Attribute not found: " + attribute);
        }
    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        switch(attribute.getName()) {
            case "cardService":
                this.cardService = (CardService) attribute.getValue();
                break;
            case "bankService":
                this.bankService = (BankService) attribute.getValue();
                break;
            default:
                throw new AttributeNotFoundException("Attribute not found: " + attribute.getName());
        }
    }


    @Override
    public AttributeList getAttributes(String[] attributes) {
        AttributeList list = new AttributeList();
        for (String attribute : attributes) {
            try {
                Object value = getAttribute(attribute);
                list.add(new Attribute(attribute, value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        AttributeList list = new AttributeList();
        for (Object obj : attributes) {
            Attribute attribute = (Attribute) obj;
            try {
                setAttribute(attribute);
                list.add(attribute);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        switch(actionName) {
            case "print":
                System.out.println("BankService: " + bankService.toString() + " CardService: " + cardService.toString());
                break;
            case "writeData":
                try {
                    doScheduledTask();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                throw new UnsupportedOperationException("Operation not supported: " + actionName);
        }
        return null;
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        MBeanAttributeInfo[] attributes = new MBeanAttributeInfo[]{
                new MBeanAttributeInfo("cardService", String.class.getName(), "The cardService attribute", true, true, false),
                new MBeanAttributeInfo("bankService", String.class.getName(), "The bankService attribute", true, true, false)
        };

        MBeanOperationInfo[] operations = new MBeanOperationInfo[]{
                new MBeanOperationInfo("print", "Prints the cardService and bankService", null, "void", MBeanOperationInfo.ACTION),
                new MBeanOperationInfo("writeData", "Writes all the data stored in DB to files banks.txt and cards.txt", null, "void", MBeanOperationInfo.ACTION)
        };

        return new MBeanInfo(this.getClass().getName(), "Simple Dynamic MBean", attributes, null, operations, null);
    }
}
