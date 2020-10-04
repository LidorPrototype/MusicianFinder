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


class Configuration{

    private List<Instruments> instrumentsList = new ArrayList<Instruments>();
    private String citiesID = "citiesList";
    private ArrayList<String> _cities = new ArrayList<String>();
    private String[] genres = new String[61];

    public Configuration() {
        initialization();
    }

    public void initialization(){
        initList();
        initGenres();
        initCities();
    }

    private void initList(){
        instrumentsList.add(new Instruments("Accordion", R.drawable.accordion));
        instrumentsList.add(new Instruments("Acoustic guitar", R.drawable.acoustic_guitar));
        instrumentsList.add(new Instruments("Angklung", R.drawable.angklung));
        instrumentsList.add(new Instruments("Baglama", R.drawable.baglama));
        instrumentsList.add(new Instruments("Bagpipes", R.drawable.bagpipes));
        instrumentsList.add(new Instruments("Balalaika", R.drawable.balalaika));
        instrumentsList.add(new Instruments("Banjo", R.drawable.banjo));
        instrumentsList.add(new Instruments("Bass drum", R.drawable.bass_drum));
        instrumentsList.add(new Instruments("Bass guitar", R.drawable.bass_guitar));
        instrumentsList.add(new Instruments("Bassoon", R.drawable.bassoon));
        instrumentsList.add(new Instruments("Bell", R.drawable.bell));
        instrumentsList.add(new Instruments("Bongo", R.drawable.bongo));
        instrumentsList.add(new Instruments("Brass", R.drawable.brass));
        instrumentsList.add(new Instruments("Bugles", R.drawable.bugles));
        instrumentsList.add(new Instruments("Cabasa", R.drawable.cabasa));
        instrumentsList.add(new Instruments("Castanet", R.drawable.castanet));
        instrumentsList.add(new Instruments("Cello", R.drawable.cello));
        instrumentsList.add(new Instruments("Chimes", R.drawable.chimes));
        instrumentsList.add(new Instruments("Clarinet", R.drawable.clarinet));
        instrumentsList.add(new Instruments("Classic guitar", R.drawable.classic_guitar));
        instrumentsList.add(new Instruments("Clave", R.drawable.clave));
        instrumentsList.add(new Instruments("Conga", R.drawable.conga));
        instrumentsList.add(new Instruments("Cymbals", R.drawable.cymbals));
        instrumentsList.add(new Instruments("Darbuka", R.drawable.darbuka));
        instrumentsList.add(new Instruments("DJ mixer", R.drawable.dj_mixer));
        instrumentsList.add(new Instruments("Djembe", R.drawable.djembe));
        instrumentsList.add(new Instruments("Domra", R.drawable.domra));
        instrumentsList.add(new Instruments("Double bass", R.drawable.double_bass));
        instrumentsList.add(new Instruments("Drum set", R.drawable.drum_set));
        instrumentsList.add(new Instruments("Drum", R.drawable.drum));
        instrumentsList.add(new Instruments("Electric drum", R.drawable.electric_drum));
        instrumentsList.add(new Instruments("Electric guitar", R.drawable.electric_guitar));
        instrumentsList.add(new Instruments("Fanfare", R.drawable.fanfare));
        instrumentsList.add(new Instruments("Flute", R.drawable.flute));
        instrumentsList.add(new Instruments("French horn", R.drawable.french_horn));
        instrumentsList.add(new Instruments("Glockenspiel", R.drawable.glockenspiel));
        instrumentsList.add(new Instruments("Gong", R.drawable.gong));
        instrumentsList.add(new Instruments("Guzheng", R.drawable.guzheng));
        instrumentsList.add(new Instruments("Harmonica", R.drawable.harmonica));
        instrumentsList.add(new Instruments("Harp", R.drawable.harp));
        instrumentsList.add(new Instruments("Hurdy gurdy", R.drawable.hurdy_gurdy));
        instrumentsList.add(new Instruments("Kalimba", R.drawable.kalimba));
        instrumentsList.add(new Instruments("Keyboard", R.drawable.keyboard));
        instrumentsList.add(new Instruments("Keytar", R.drawable.keytar));
        instrumentsList.add(new Instruments("Koto", R.drawable.koto));
        instrumentsList.add(new Instruments("Lute", R.drawable.lute));
        instrumentsList.add(new Instruments("Lyre", R.drawable.lyre));
        instrumentsList.add(new Instruments("Mandolin", R.drawable.mandolin));
        instrumentsList.add(new Instruments("Maracas", R.drawable.maracas));
        instrumentsList.add(new Instruments("Marimba", R.drawable.marimba));
        instrumentsList.add(new Instruments("Melodic", R.drawable.melodic));
        instrumentsList.add(new Instruments("Microphone", R.drawable.microphone));
        instrumentsList.add(new Instruments("Oboe", R.drawable.oboe));
        instrumentsList.add(new Instruments("Organ", R.drawable.organ));
        instrumentsList.add(new Instruments("Panpipe", R.drawable.panpipe));
        instrumentsList.add(new Instruments("Piano", R.drawable.piano));
        instrumentsList.add(new Instruments("Pipa", R.drawable.pipa));
        instrumentsList.add(new Instruments("Qanum", R.drawable.qanun));
        instrumentsList.add(new Instruments("Rebec", R.drawable.rebec));
        instrumentsList.add(new Instruments("Recorder", R.drawable.recorder));
        instrumentsList.add(new Instruments("Reed", R.drawable.reed));
        instrumentsList.add(new Instruments("Santoor", R.drawable.santoor));
        instrumentsList.add(new Instruments("Saxophone", R.drawable.saxophone));
        instrumentsList.add(new Instruments("Shamisen", R.drawable.shamisen));
        instrumentsList.add(new Instruments("Sitar", R.drawable.sitar));
        instrumentsList.add(new Instruments("Snare drum", R.drawable.snare_drum));
        instrumentsList.add(new Instruments("Tabla", R.drawable.tabla));
        instrumentsList.add(new Instruments("Tambourine", R.drawable.tambourine));
        instrumentsList.add(new Instruments("Theremin", R.drawable.theremin));
        instrumentsList.add(new Instruments("Timpani", R.drawable.timpani));
        instrumentsList.add(new Instruments("Triangle", R.drawable.triangle));
        instrumentsList.add(new Instruments("Trombone", R.drawable.trombone));
        instrumentsList.add(new Instruments("Trumpet", R.drawable.trumpet));
        instrumentsList.add(new Instruments("Tuba", R.drawable.tuba));
        instrumentsList.add(new Instruments("Ukulele", R.drawable.ukelele));
        instrumentsList.add(new Instruments("Viola", R.drawable.viola));
        instrumentsList.add(new Instruments("Violin", R.drawable.violin));
        instrumentsList.add(new Instruments("Vuvuzela", R.drawable.vuvuzela));
        instrumentsList.add(new Instruments("Xylophone", R.drawable.xylophone));
    }

    private void initGenres(){          /* In User.java you need to add the number of genres manually!!! */
        genres[0] = ("Africa music");
        genres[1] = ("Alternative");
        genres[2] = ("Ambient");
        genres[3] = ("Art");
        genres[4] = ("Bluegrass");
        genres[5] = ("Blues");
        genres[6] = ("Breakbeat");
        genres[7] = ("Chant");
        genres[8] = ("Classical");
        genres[9] = ("Country");
        genres[10] = ("Crossover");
        genres[11] = ("Dance");
        genres[12] = ("Disco");
        genres[13] = ("Drum 'N' Base");
        genres[14] = ("Dubstep");
        genres[15] = ("Easy Listening");
        genres[16] = ("Electro");
        genres[17] = ("Electronic Dance");
        genres[18] = ("Emo");
        genres[19] = ("Folk");
        genres[20] = ("Funk");
        genres[21] = ("Gospel");
        genres[22] = ("Grunge");
        genres[23] = ("Hard Rock");
        genres[24] = ("Hardcore");
        genres[25] = ("Heavy Metal");
        genres[26] = ("Hip Hop");
        genres[27] = ("House");
        genres[28] = ("Indie Rock");
        genres[29] = ("Industrial");
        genres[30] = ("Instrumental");
        genres[31] = ("Jazz");
        genres[32] = ("Jazz Fusion");
        genres[33] = ("Jungle Music");
        genres[34] = ("K-pop");
        genres[35] = ("Latin");
        genres[36] = ("Metal");
        genres[37] = ("Musical Theatre");
        genres[38] = ("New Wave");
        genres[39] = ("Opera");
        genres[40] = ("Orchestra");
        genres[41] = ("Pop");
        genres[42] = ("Pop Rock");
        genres[43] = ("Progressive ");
        genres[44] = ("Punk Rock");
        genres[45] = ("Rap");
        genres[46] = ("Reggae");
        genres[47] = ("Rhythm and Blues");
        genres[48] = ("Rock");
        genres[49] = ("Rock ‘N’ Roll");
        genres[50] = ("Singing");
        genres[51] = ("Ska");
        genres[52] = ("Soul");
        genres[53] = ("Swing");
        genres[54] = ("Synth-pop");
        genres[55] = ("Techno");
        genres[56] = ("Trance");
        genres[57] = ("Trap");
        genres[58] = ("Vocal");
        genres[59] = ("Western");
        genres[60] = ("World");
    }

    private void initCities(){
        _cities = new ArrayList<>(
                Arrays.asList(
                        "Lod","Tel Aviv","Jerusalem","Maale Adomim","Kfar Saba","Or Yehuda","Azor",
                        "Bat Yam","Ramat Gan","Holon","Ashdod","Be'er Sheva","Yehud","Rishon LeZion",
                        "Hazav","Ness Ziona","Eilat","Rehovot","Herzliya","Nahariya","Haifa",
                        "Shave Ziyyon","Ramat HaSharon","Ramat Poleg","Kadima","Karmi'el","Pardesiyya",
                        "Netanya","Gan Yavne","Petah Tikwah","Ashqelon","Savyon","Naham",
                        "Mazkeret Batya","`Arugot","Ofaqim","Shetulim","Hadera","Qiryat Bialik",
                        "Tel Mond","Hod HaSharon","Qiryat Yam","Shelomi","Binyamina","Liman","`Alma",
                        "Ramla","Nazareth","Et Taiyiba","Rinnatya","Yavne","Acre","Nazerat `Illit",
                        "Baraq","Even Yehuda","Nesher","Pardes Hanna Karkur","Netivot","Tirat Karmel",
                        "Or `Aqiva","Kefar Yona","Afula","Bet Oren","Haluz","Biriyya","Gan Hayyim",
                        "Qiryat Tiv`on","Qiryat Gat","Be'er Toviyya","`En Ayyala",
                        "Misgav Regional Council","Safed","Gedera","Dimona","Bet Shemesh",
                        "`En HaShelosha","Herut","Mazor","Shamir","Ra'anana","Bat Hadar",
                        "Rosh Ha'Ayin","Zoran","Tirat Yehuda","Bareqet","Elyakhin","Hadid",
                        "Hadar Ramatayim","Modiin","Hazor Ashdod","Kefar Daniyyel","Newe Efrayim",
                        "Talme Menashe","Kefar Netter","Mazliah","Moran","Shoval","Ramat Aviv",
                        "Afiqim","Ramat Dawid","Sde Warburg","Magen","Karkur","Qiryat Ata","Maghar",
                        "Bet Alfa","Timrat","Elyaqim","Bet Dagan","Ginnosar","Qiryat Mal'akhi",
                        "Hadar `Am","maalot Tarshiha","Ahituv","Qiryat Motzkin","Migdal","Bat Hefer",
                        "Ben Shemen-Kefar Hano`ar","Emunim","Tiberias","Mikhmoret","Hever",
                        "Ramat Yishay","Sderot","Gimzo","Mesillat Ziyyon","Pasuta","Bet She'an",
                        "Newe Yamin","Nordiyya","HaKarmiel","Giv'atayim","Gibbeton","Qiryat Ono",
                        "Sarid","Nir Zevi","Ramat Ef`al","Bene Ziyyon","Hurfeish","Shefayim",
                        "Dabburiya","Rishpon","Mizpe Netofa","Sde Boker","Yaqum","Bahan","Jaffa",
                        "Allonim","`Evron","Hazor HaGelilit","Ramot Naftali","Giv`at Hayyim","Urim",
                        "Sedot Yam","`Aseret","Nirim","`Amir","Ganne Tiqwa","Ma`agan Mikha'el",
                        "Qiryat Hayyim","Kefar Witqin"
                )
        );
    }

    public String[] getGenres() {
        return genres;
    }
    public List<Instruments> getInstruments() {
        return instrumentsList;
    }
    public ArrayList<String> getCities() {
        return _cities;
    }
}

class Instruments {
    final int numberOfInstruments = 79;
    private String instrument = "";
    private int ID;
    public Instruments(String name, int _ID){
        this.instrument = name;
        this.ID = _ID;
    }
    public Instruments(){ }
    public String getInstrument() {
        return instrument;
    }
    public int getID() {
        return ID;
    }
    public int getNumberOfInstruments() {
        return numberOfInstruments;
    }
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
    public void setID(int _ID) {
        this.ID = _ID;
    }
}
