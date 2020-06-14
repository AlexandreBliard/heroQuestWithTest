package com.heroquest;

import com.heroquest.pj.CommunPeople;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ChooseYourCharacterTest {

    @Test
    public void chooseYourCharacterWithGuerrier() {
        ChooseYourCharacter chooseYourCharacter = new ChooseYourCharacter();
        String data = "Chris\nGUERRIER\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(data.getBytes()));

        CommunPeople aventurier = chooseYourCharacter.chooseYourCharacter(scanner);
        assertEquals("Chris", aventurier.getName());
        assertEquals("guerrier", aventurier.getType());
    }

    @Test
    public void chooseYourCharacterWithBadInput() {
        ChooseYourCharacter chooseYourCharacter = new ChooseYourCharacter();
        String data = "Chris\nDWARF\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(data.getBytes()));

        try {
            CommunPeople aventurier = chooseYourCharacter.chooseYourCharacter(scanner);
            fail("dwarf should not be accepted as adventurer");
        } catch (RuntimeException exception) {
            // ok, expect to fail if
        }
    }
}