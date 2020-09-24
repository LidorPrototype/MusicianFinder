package com.LYEO.musicianfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lidor on 9/24/2020.
 * Website: www.buckystudents.com
 *  _        _   _____     ____    ______
 * | |      |_| |  __ \   / __ \  |  O   |
 * | |      | | | |  | | | |  | | |   __/
 * | |____  | | | |__| | | |__| | | | \
 * |______| |_| |_____/   \____/  |_|__\
 *  ____         ____
 * |  __|       |  __|
 * |  __|   _   |__  |
 * |____|  |_|  |____|
 */

/*
 * Contributions:
 *
 * Instruments Icons were made by
 * Link:
 * 1-instrument.zip ->  iconixar    -   https://www.flaticon.com/authors/iconixar
 * 2-instrument.zip ->  Freepik    -   https://www.flaticon.com/authors/freepik
 * 3-instrument.zip ->  Freepik    -   https://www.flaticon.com/authors/freepik
 * 4-instrument.zip ->  Freepik    -   https://www.flaticon.com/authors/freepik
 * 5-instrument.zip ->  Freepik    -   https://www.flaticon.com/authors/freepik
 */

class Instruments {

    private String instrument = "";
    private int ID;
    public Instruments(String name, int _ID){
        this.instrument = name;
        this.ID = _ID;
    }

    public String getInstrument() {
        return instrument;
    }
    public int getID() {
        return ID;
    }
    public int getNumberOfInstruments() {
        return numberOfInstruments;
    }
    public List<Instruments> getInstruments() {
        return Instruments;
    }
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
    public void setID(int _ID) {
        this.ID = _ID;
    }
    public void setInstruments(List<Instruments> instruments) {
        Instruments = instruments;
    }

    final int numberOfInstruments = 79;

    private List<Instruments> Instruments =
                new ArrayList<Instruments>(Arrays.<Instruments>asList(
                        new Instruments("Accordion", R.drawable.accordion),
                        new Instruments("Acoustic guitar", R.drawable.acoustic_guitar),
                        new Instruments("Angklung", R.drawable.angklung),
                        new Instruments("Baglama", R.drawable.baglama),
                        new Instruments("Bagpipes", R.drawable.bagpipes),
                        new Instruments("Balalaika", R.drawable.balalaika),
                        new Instruments("Banjo", R.drawable.banjo),
                        new Instruments("Bass drum", R.drawable.bass_drum),
                        new Instruments("Bass guitar", R.drawable.bass_guitar),
                        new Instruments("Bassoon", R.drawable.bassoon),
                        new Instruments("Bell", R.drawable.bell),
                        new Instruments("Bongo", R.drawable.bongo),
                        new Instruments("Brass", R.drawable.brass),
                        new Instruments("Bugles", R.drawable.bugles),
                        new Instruments("Cabasa", R.drawable.cabasa),
                        new Instruments("Castanet", R.drawable.castanet),
                        new Instruments("Cello", R.drawable.cello),
                        new Instruments("Chimes", R.drawable.chimes),
                        new Instruments("Clarinet", R.drawable.clarinet),
                        new Instruments("Classic guitar", R.drawable.classic_guitar),
                        new Instruments("Clave", R.drawable.clave),
                        new Instruments("Conga", R.drawable.conga),
                        new Instruments("Cymbals", R.drawable.cymbals),
                        new Instruments("Darbuka", R.drawable.darbuka),
                        new Instruments("DJ mixer", R.drawable.dj_mixer),
                        new Instruments("Djembe", R.drawable.djembe),
                        new Instruments("Domra", R.drawable.domra),
                        new Instruments("Double bass", R.drawable.double_bass),
                        new Instruments("Drum set", R.drawable.drum_set),
                        new Instruments("Drum", R.drawable.drum),
                        new Instruments("Electric drum", R.drawable.electric_drum),
                        new Instruments("Electric guitar", R.drawable.electric_guitar),
                        new Instruments("Fanfare", R.drawable.fanfare),
                        new Instruments("Flute", R.drawable.flute),
                        new Instruments("French horn", R.drawable.french_horn),
                        new Instruments("Glockenspiel", R.drawable.glockenspiel),
                        new Instruments("Gong", R.drawable.gong),
                        new Instruments("Guzheng", R.drawable.guzheng),
                        new Instruments("Harmonica", R.drawable.harmonica),
                        new Instruments("Harp", R.drawable.harp),
                        new Instruments("Hurdy gurdy", R.drawable.hurdy_gurdy),
                        new Instruments("Kalimba", R.drawable.kalimba),
                        new Instruments("Keyboard", R.drawable.keyboard),
                        new Instruments("Keytar", R.drawable.keytar),
                        new Instruments("Koto", R.drawable.koto),
                        new Instruments("Lute", R.drawable.lute),
                        new Instruments("Lyre", R.drawable.lyre),
                        new Instruments("Mandolin", R.drawable.mandolin),
                        new Instruments("Maracas", R.drawable.maracas),
                        new Instruments("Marimba", R.drawable.marimba),
                        new Instruments("Melodic", R.drawable.melodic),
                        new Instruments("Microphone", R.drawable.microphone),
                        new Instruments("Oboe", R.drawable.oboe),
                        new Instruments("Organ", R.drawable.organ),
                        new Instruments("Panpipe", R.drawable.panpipe),
                        new Instruments("Piano", R.drawable.piano),
                        new Instruments("Pipa", R.drawable.pipa),
                        new Instruments("Qanum", R.drawable.qanun),
                        new Instruments("Rebec", R.drawable.rebec),
                        new Instruments("Recorder", R.drawable.recorder),
                        new Instruments("Reed", R.drawable.reed),
                        new Instruments("Santoor", R.drawable.santoor),
                        new Instruments("Saxophone", R.drawable.saxophone),
                        new Instruments("Shamisen", R.drawable.shamisen),
                        new Instruments("Sitar", R.drawable.sitar),
                        new Instruments("Snare drum", R.drawable.snare_drum),
                        new Instruments("Tabla", R.drawable.tabla),
                        new Instruments("Tambourine", R.drawable.tambourine),
                        new Instruments("Theremin", R.drawable.theremin),
                        new Instruments("Timpani", R.drawable.timpani),
                        new Instruments("Triangle", R.drawable.triangle),
                        new Instruments("Trombone", R.drawable.trombone),
                        new Instruments("Trumpet", R.drawable.trumpet),
                        new Instruments("Tuba", R.drawable.tuba),
                        new Instruments("Ukulele", R.drawable.ukelele),
                        new Instruments("Viola", R.drawable.viola),
                        new Instruments("Violin", R.drawable.violin),
                        new Instruments("Vuvuzela", R.drawable.vuvuzela),
                        new Instruments("Xylophone", R.drawable.xylophone)
                )
            );

}
