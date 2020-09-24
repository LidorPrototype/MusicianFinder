package com.LYEO.musicianfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lidor on 9/24/2020.
 * Website: www.buckystudents.com
 *  _        _   _____     ____    ______
 * | |      |_| |  __ \   / __ \  |  O   |
 * | |      | | | |  | | | |  | | |   ___/
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

class configuration {

    public List<String> Instruments =
                new ArrayList<>(Arrays.asList(
                        "Accordion",
                        "Acoustic guitar",
                        "Amplifier",
                        "Angklung",
                        "Baglama",
                        "Bagpipes",
                        "Balalaika",
                        "Banjo",
                        "Bass drum",
                        "Bass guitar",
                        "Bassoon",
                        "Bell",
                        "Bongo",
                        "Brass",
                        "Bugles",
                        "Cabasa",
                        "Castanet",
                        "Cello",
                        "Chimes",
                        "Clarinet",
                        "Classic guitar",
                        "Clave",
                        "Conga",
                        "Cymbal",
                        "Cymbals",
                        "Darbuka",
                        "DJ mixer",
                        "Djembe",
                        "Dorma",
                        "Double bass",
                        "Drum set",
                        "Electric drum",
                        "Electric guitar",
                        "Fanfare",
                        "Flute",
                        "French horn",
                        "Glockenspiel",
                        "Gong",
                        "Grand piano",
                        "Guitar",
                        "Guzheng",
                        "Harmonica",
                        "Harp",
                        "Hurdy gurdy",
                        "Kalimba",
                        "Keyboard",
                        "Keytar",
                        "Koto",
                        "Lute",
                        "Lyre",
                        "Mandolin",
                        "Maracas",
                        "Marimba",
                        "Melodica",
                        "Melodion",
                        "Metronome",
                        "Microphone",
                        "Oboe",
                        "Organ",
                        "Panpipe",
                        "Piano",
                        "Pipa",
                        "Qanum",
                        "Rebec",
                        "Recorder",
                        "Reed",
                        "Santoor",
                        "Saxophone",
                        "Shamisen",
                        "Sitar",
                        "Snare drum",
                        "Tabla",
                        "Tambourine",
                        "Theremin",
                        "Timpani",
                        "Triangle",
                        "Trombone",
                        "Trumpet",
                        "Tuba",
                        "Ukulele",
                        "Viola",
                        "Violin",
                        "Vuvuzela",
                        "Xylophone"
                )
            );



//    public List<Pair<String, Integer>> Instruments =
//                new ArrayList<Pair<String, Integer>>(Arrays.asList(
//                        new Pair<>("Accordion",4),
//                        new Pair<>("2.\tAcoustic guitar",4),
//                        new Pair<>("3.\tAmplifier",4),
//                        new Pair<>("Angklung",4),
//                        new Pair<>("5.\tBaglama",4),
//                        new Pair<>("6.\tBagpipes",4),
//                        new Pair<>("7.\tBalalaika",4),
//                        new Pair<>("8.\tBanjo",4),
//                        new Pair<>("9.\tBass drum",4),
//                        new Pair<>("10.\tBass guitar",4),
//                        new Pair<>("Bassoon",4),
//                        new Pair<>("12.\tBell",4),
//                        new Pair<>("13.\tBongo",4),
//                        new Pair<>("14.\tBrass",4),
//                        new Pair<>("15.\tBugles",4),
//                        new Pair<>("16.\tCabasa",4),
//                        new Pair<>("17.\tCastanet",4),
//                        new Pair<>("18.\tCello",4),
//                        new Pair<>("19.\tChimes",4),
//                        new Pair<>("20.\tClarinet",4),
//                        new Pair<>("21.\tClassic guitar",4),
//                        new Pair<>("22.\tClave",4),
//                        new Pair<>("23.\tConga",4),
//                        new Pair<>("24.\tCymbal",4),
//                        new Pair<>("25.\tCymbals",4),
//                        new Pair<>("26.\tDarbuka",4),
//                        new Pair<>("27.\tDJ mixer",4),
//                        new Pair<>("28.\tDjembe",4),
//                        new Pair<>("29.\tDorma",4),
//                        new Pair<>("30.\tDouble bass",4),
//                        new Pair<>("31.\tDrum set",4),
//                        new Pair<>("32.\tElectric drum",4),
//                        new Pair<>("33.\tElectric guitar",4),
//                        new Pair<>("34.\tFanfare",4),
//                        new Pair<>("35.\tFlute",4),
//                        new Pair<>("1.\tFrench horn",4),
//                        new Pair<>("37.\tGlockenspiel",4),
//                        new Pair<>("38.\tGong",4),
//                        new Pair<>("39.\tGrand piano",4),
//                        new Pair<>("40.\tGuitar",4),
//                        new Pair<>("41.\tGuzheng",4),
//                        new Pair<>("42.\tHarmonica",4),
//                        new Pair<>("43.\tHarp",4),
//                        new Pair<>("44.\tHurdy gurdy",4),
//                        new Pair<>("45.\tKalimba",4),
//                        new Pair<>("46.\tKeyboard",4),
//                        new Pair<>("47.\tKeytar",4),
//                        new Pair<>("48.\tKoto",4),
//                        new Pair<>("49.\tLute",4),
//                        new Pair<>("50.\tLyre",4),
//                        new Pair<>("51.\tMandolin",4),
//                        new Pair<>("52.\tMaracas",4),
//                        new Pair<>("53.\tMarimba",4),
//                        new Pair<>("54.\tMelodica",4),
//                        new Pair<>("55.\tMelodion",4),
//                        new Pair<>("56.\tMetronome",4),
//                        new Pair<>("57.\tMicrophone",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4),
//                        new Pair<>("Accordion",4)
//                        )
//                );

}
