package com.LYEO.musicianfinder;

import android.content.res.Resources;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.LYEO.musicianfinder.Login.cn1;

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


public class Configuration extends FragmentActivity {

    private List<Instruments> instrumentsList = new ArrayList<Instruments>();
    private String citiesID = "citiesList";
    private ArrayList<String> _cities = new ArrayList<String>();
    private ArrayList<String> instrumentsArrayList = new ArrayList<String>();
    private ArrayList<String> genresArrayList = new ArrayList<String>();
    private String[] genres = new String[61];
    private String tou = "", pp = "";

    private int height = 0;

    public Configuration() {
        initialization();
    }

    public void initialization(){
        initList();
        initGenres();
        initCities();
        // Size of the device default AppBar height
        Resources resources = cn1.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            height = resources.getDimensionPixelSize(resourceId);   // height now set tot he height of the bottom navigation bar
        }
    }

    public void openInfoDialog(int type){
        /**
         * type = 0     -->     TermOfUse + PrivacyPolicy           (Default Value, Enter Negative)
         * type = 1     -->     Generated Password For User
         * */
        if(type < 0){type = 0;}
        TOU_PP_Dialog dialogInfo = new TOU_PP_Dialog().newInstance(type);
        dialogInfo.show(getSupportFragmentManager(), "info dialog");
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
        for (int i = 0; i < instrumentsList.size(); i++) {
            instrumentsArrayList.add(instrumentsList.get(i).getInstrument());
        }
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
        genresArrayList.addAll(Arrays.asList(genres));
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

    public String getAndInitTOU(){
        tou += "<h1><u><b>Terms and Conditions for Musician Finder</b></u></h1>\n" +
                "<h3><b>Terms and Conditions</b></h3>\n" +
                "<p>\n" +
                "Last updated: October 11, 2020 <br>\n" +
                "Please read these terms and conditions carefully before using Our Service.\n" +
                "</p>\n" +
                "<h3><b>Interpretation and Definitions</b></h3>\n" +
                "<h4>Interpretation</h4>\n" +
                "<p>\n" +
                "The words of which the initial letter is capitalized have meanings defined under the following conditions. The following definitions shall have the same meaning regardless of whether they appear in singular or in plural.\n" +
                "</p>\n" +
                "<h4>Definitions</h4>\n" +
                "<p>\n" +
                "For the purposes of these Terms and Conditions: <br>\n" +
                "<ul>\n" +
                "\t<li><b>Affiliate</b></li> means an entity that controls, is controlled by or is under common control with a party, where \"control\" means ownership of 50% or more of the shares, equity interest or other securities entitled to vote for election of directors or other managing authority.\n" +
                "\t<li><b>Country</b></li> refers to: Israel\n" +
                "\t<li><b>Company</b></li> (referred to as either \"the Company\", \"We\", \"Us\" or \"Our\" in this Agreement) refers to Musician Finder.\n" +
                "\t<li><b>Device</b></li> means any device that can access the Service such as a computer, a cellphone or a digital tablet.\n" +
                "\t<li><b>Service</b></li> refers to the Website.\n" +
                "\t<li><b>Terms and Conditions</b></li> (also referred as \"Terms\") mean these Terms and Conditions that form the entire agreement between You and the Company regarding the use of the Service. This Terms and Conditions agreement has been created with the help of the Terms and Conditions Generator.\n" +
                "\t<li><b>Third-party Social Media Service</b></li> means any services or content (including data, information, products or services) provided by a third-party that may be displayed, included or made available by the Service.\n" +
                "\t<li><b>You</b></li> mean the individual accessing or using the Service, or the company, or other legal entity on behalf of which such individual is accessing or using the Service, as applicable.\n" +
                "</ul>\n" +
                "</p>\n" +
                "<h3><b>Acknowledgment</b></h3>\n" +
                "<p>\n" +
                "These are the Terms and Conditions governing the use of this Service and the agreement that operates between You and the Company. These Terms and Conditions set out the rights and obligations of all users regarding the use of the Service.<br>\n" +
                "Your access to and use of the Service is conditioned on Your acceptance of and compliance with these Terms and Conditions. These Terms and Conditions apply to all visitors, users and others who access or use the Service.<br>\n" +
                "By accessing or using the Service You agree to be bound by these Terms and Conditions. If You disagree with any part of these Terms and Conditions then You may not access the Service.<br>\n" +
                "You represent that you are over the age of 18. The Company does not permit those under 18 to use the Service.<br>\n" +
                "Your access to and use of the Service is also conditioned on Your acceptance of and compliance with the Privacy Policy of the Company. Our Privacy Policy describes Our policies and procedures on the collection, use and disclosure of Your personal information when You use the Application or the Website and tells You about Your privacy rights and how the law protects You. Please read Our Privacy Policy carefully before using Our Service.\n" +
                "</p>\n" +
                "<h3><b>Links to Other Websites</b></h3>\n" +
                "<p>\n" +
                "Our Service may contain links to third-party web sites or services that are not owned or controlled by the Company.<br>\n" +
                "The Company has no control over, and assumes no responsibility for, the content, privacy policies, or practices of any third party web sites or services. You further acknowledge and agree that the Company shall not be responsible or liable, directly or indirectly, for any damage or loss caused or alleged to be caused by or in connection with the use of or reliance on any such content, goods or services available on or through any such web sites or services.<br>\n" +
                "We strongly advise You to read the terms and conditions and privacy policies of any third-party web sites or services that You visit.\n" +
                "</p>\n" +
                "<h3><b>Termination</b></h3>\n" +
                "<p>\n" +
                "We may terminate or suspend Your access immediately, without prior notice or liability, for any reason whatsoever, including without limitation if You breach these Terms and Conditions.<br>\n" +
                "Upon termination, Your right to use the Service will cease immediately.\n" +
                "</p>\n" +
                "<h3><b>Limitation of Liability</b></h3>\n" +
                "<p>\n" +
                "Notwithstanding any damages that You might incur, the entire liability of the Company and any of its suppliers under any provision of this Terms and Your exclusive remedy for all of the foregoing shall be limited to the amount actually paid by You through the Service or 100 USD if You haven't purchased anything through the Service.<br>\n" +
                "To the maximum extent permitted by applicable law, in no event shall the Company or its suppliers be liable for any special, incidental, indirect, or consequential damages whatsoever (including, but not limited to, damages for loss of profits, loss of data or other information, for business interruption, for personal injury, loss of privacy arising out of or in any way related to the use of or inability to use the Service, third-party software and/or third-party hardware used with the Service, or otherwise in connection with any provision of this Terms), even if the Company or any supplier has been advised of the possibility of such damages and even if the remedy fails of its essential purpose.<br>\n" +
                "Some states do not allow the exclusion of implied warranties or limitation of liability for incidental or consequential damages, which means that some of the above limitations may not apply. In these states, each party's liability will be limited to the greatest extent permitted by law.\n" +
                "</p>\n" +
                "<h3><b>\"AS IS\" and \"AS AVAILABLE\" Disclaimer</b></h3>\n" +
                "<p>\n" +
                "The Service is provided to You \"AS IS\" and \"AS AVAILABLE\" and with all faults and defects without warranty of any kind. To the maximum extent permitted under applicable law, the Company, on its own behalf and on behalf of its Affiliates and its and their respective licensors and service providers, expressly disclaims all warranties, whether express, implied, statutory or otherwise, with respect to the Service, including all implied warranties of merchantability, fitness for a particular purpose, title and non-infringement, and warranties that may arise out of course of dealing, course of performance, usage or trade practice. Without limitation to the foregoing, the Company provides no warranty or undertaking, and makes no representation of any kind that the Service will meet Your requirements, achieve any intended results, be compatible or work with any other software, applications, systems or services, operate without interruption, meet any performance or reliability standards or be error free or that any errors or defects can or will be corrected.<br>\n" +
                "Without limiting the foregoing, neither the Company nor any of the company's provider makes any representation or warranty of any kind, express or implied: (i) as to the operation or availability of the Service, or the information, content, and materials or products included thereon; (ii) that the Service will be uninterrupted or error-free; (iii) as to the accuracy, reliability, or currency of any information or content provided through the Service; or (iv) that the Service, its servers, the content, or e-mails sent from or on behalf of the Company are free of viruses, scripts, trojan horses, worms, malware, timebombs or other harmful components.<br>\n" +
                "Some jurisdictions do not allow the exclusion of certain types of warranties or limitations on applicable statutory rights of a consumer, so some or all of the above exclusions and limitations may not apply to You. But in such a case the exclusions and limitations set forth in this section shall be applied to the greatest extent enforceable under applicable law.\n" +
                "</p>\n" +
                "<h3><b>Governing Law</b></h3>\n" +
                "<p>\n" +
                "The laws of the Country, excluding its conflicts of law rules, shall govern this Terms and Your use of the Service. Your use of the Application may also be subject to other local, state, national, or international laws.\n" +
                "</p>\n" +
                "<h3><b>Disputes Resolution</b></h3>\n" +
                "<p>\n" +
                "If You have any concern or dispute about the Service, You agree to first try to resolve the dispute informally by contacting the Company.\n" +
                "</p>\n" +
                "<h3><b>For European Union (EU) Users</b></h3>\n" +
                "<p>\n" +
                "If You are a European Union consumer, you will benefit from any mandatory provisions of the law of the country in which you are resident in.\n" +
                "</p>\n" +
                "<h3><b>United States Legal Compliance</b></h3>\n" +
                "<p>\n" +
                "You represent and warrant that (i) You are not located in a country that is subject to the United States government embargo, or that has been designated by the United States government as a \"terrorist supporting\" country, and (ii) You are not listed on any United States government list of prohibited or restricted parties.\n" +
                "</p>\n" +
                "<h3><b>Severability and Waiver</b></h3>\n" +
                "<h4>Severability</h4>\n" +
                "<p>\n" +
                "If any provision of these Terms is held to be unenforceable or invalid, such provision will be changed and interpreted to accomplish the objectives of such provision to the greatest extent possible under applicable law and the remaining provisions will continue in full force and effect.\n" +
                "</p>\n" +
                "<h4>Waiver</h4>\n" +
                "<p>\n" +
                "Except as provided herein, the failure to exercise a right or to require performance of an obligation under this Terms shall not effect a party's ability to exercise such right or require such performance at any time thereafter nor shall be the waiver of a breach constitute a waiver of any subsequent breach.\n" +
                "</p>\n" +
                "<h3><b>Translation Interpretation</b></h3>\n" +
                "<p>\n" +
                "These Terms and Conditions may have been translated if We have made them available to You on our Service. You agree that the original English text shall prevail in the case of a dispute.\n" +
                "</p>\n" +
                "<h3><b>Changes to These Terms and Conditions</b></h3>\n" +
                "<p>\n" +
                "We reserve the right, at Our sole discretion, to modify or replace these Terms at any time. If a revision is material We will make reasonable efforts to provide at least 30 days' notice prior to any new terms taking effect. What constitutes a material change will be determined at Our sole discretion.<br>\n" +
                "By continuing to access or use Our Service after those revisions become effective, You agree to be bound by the revised terms. If You do not agree to the new terms, in whole or in part, please stop using the website and the Service.\n" +
                "</p>\n" +
                "<h3><b>Contact Us</b></h3>\n" +
                "<p>\n" +
                "If you have any questions about these Terms and Conditions, You can contact us:<br>\n" +
                "<br><ul>\n" +
                "\t<li>By email: findermusician@gmail.com </li>\n" +
                "</ul>\n" +
                "Terms and Conditions for Musician Finder\n" +
                "</p>\n";
        return  tou;
    }
    public String getAndInitPP(){
        pp += "<h1><u><b>Privacy Policy for Musician Finder</b></u></h1>\n" +
                "<h3><b>Privacy Policy</b></h3>\n" +
                "<p>\n" +
                "Last updated: October 11, 2020<br>\n" +
                "This Privacy Policy describes Our policies and procedures on the collection, use and disclosure of Your information when You use the Service and tells You about Your privacy rights and how the law protects You.<br>\n" +
                "We use Your Personal data to provide and improve the Service. By using the Service, You agree to the collection and use of information in accordance with this Privacy Policy. This Privacy Policy has been created with the help of the Privacy Policy Generator.\n" +
                "</p>\n" +
                "<h3><b>Interpretation and Definitions</b></h3>\n" +
                "<h4>Interpretation</h4>\n" +
                "<p>\n" +
                "The words of which the initial letter is capitalized have meanings defined under the following conditions. The following definitions shall have the same meaning regardless of whether they appear in singular or in plural.\n" +
                "</p>\n" +
                "<h4>Definitions</h4>\n" +
                "<p>\n" +
                "For the purposes of this Privacy Policy:\n" +
                "<ul>\n" +
                "<li><b>Account</b></li>  means a unique account created for You to access our Service or parts of our Service.\n" +
                "<li><b>Company</b></li>  (referred to as either \"the Company\", \"We\", \"Us\" or \"Our\" in this Agreement) refers to Musician Finder.\n" +
                "<li><b>Country</b></li>  refers to: Israel\n" +
                "<li><b>Device</b></li>  means any device that can access the Service such as a computer, a cellphone or a digital tablet.\n" +
                "<li><b>Personal Data</b></li>  is any information that relates to an identified or identifiable individual.\n" +
                "<li><b>Service Provider</b></li>  means any natural or legal person who processes the data on behalf of the Company. It refers to third-party companies or individuals employed by the Company to facilitate the Service, to provide the Service on behalf of the Company, to perform services related to the Service or to assist the Company in analyzing how the Service is used.\n" +
                "<li><b>Third-party Social Media Service</b></li> refers to any website or any social network website through which a User can log in or create an account to use the Service.\n" +
                "<li><b>Usage Data</b></li> refers to data collected automatically, either generated by the use of the Service or from the Service infrastructure itself (for example, the duration of a page visit).\n" +
                "<li><b>You</b></li> means the individual accessing or using the Service, or the company, or other legal entity on behalf of which such individual is accessing or using the Service, as applicable.\n" +
                "</ul>\n" +
                "</p>\n" +
                "<h3><b>Collecting and Using Your Personal Data</b></h3>\n" +
                "Types of Data Collected\n" +
                "Personal Data\n" +
                "While using Our Service, We may ask You to provide Us with certain personally identifiable information that can be used to contact or identify You. Personally identifiable information may include, but is not limited to:\n" +
                "•\tFirst name and last name\n" +
                "•\tAddress, State, Province, ZIP/Postal code, City\n" +
                "•\tUsage Data\n" +
                "Usage Data\n" +
                "Usage Data is collected automatically when using the Service.\n" +
                "Usage Data may include information such as Your Device's Internet Protocol address (e.g. IP address), browser type, browser version, the pages of our Service that You visit, the time and date of Your visit, the time spent on those pages, unique device identifiers and other diagnostic data.\n" +
                "When You access the Service by or through a mobile device, We may collect certain information automatically, including, but not limited to, the type of mobile device You use, Your mobile device unique ID, the IP address of Your mobile device, Your mobile operating system, the type of mobile Internet browser You use, unique device identifiers and other diagnostic data.\n" +
                "We may also collect information that Your browser sends whenever You visit our Service or when You access the Service by or through a mobile device.\n" +
                "Use of Your Personal Data\n" +
                "The Company may use Personal Data for the following purposes:\n" +
                "•\tTo provide and maintain our Service, including to monitor the usage of our Service.\n" +
                "•\tTo manage Your Account: to manage Your registration as a user of the Service. The Personal Data You provide can give You access to different functionalities of the Service that are available to You as a registered user.\n" +
                "•\tFor the performance of a contract: the development, compliance and undertaking of the purchase contract for the products, items or services You have purchased or of any other contract with Us through the Service.\n" +
                "•\tTo contact You: To contact You by email, telephone calls, SMS, or other equivalent forms of electronic communication, such as a mobile application's push notifications regarding updates or informative communications related to the functionalities, products or contracted services, including the security updates, when necessary or reasonable for their implementation.\n" +
                "•\tTo provide You with news, special offers and general information about other goods, services and events which we offer that are similar to those that you have already purchased or enquired about unless You have opted not to receive such information.\n" +
                "•\tTo manage Your requests: To attend and manage Your requests to Us.\n" +
                "We may share your personal information in the following situations:\n" +
                "•\tWith Service Providers: We may share Your personal information with Service Providers to monitor and analyze the use of our Service, to contact You.\n" +
                "•\tFor Business transfers: We may share or transfer Your personal information in connection with, or during negotiations of, any merger, sale of Company assets, financing, or acquisition of all or a portion of our business to another company.\n" +
                "•\tWith Affiliates: We may share Your information with Our affiliates, in which case we will require those affiliates to honor this Privacy Policy. Affiliates include Our parent company and any other subsidiaries, joint venture partners or other companies that We control or that are under common control with Us.\n" +
                "•\tWith Business partners: We may share Your information with Our business partners to offer You certain products, services or promotions.\n" +
                "•\tWith other users: when You share personal information or otherwise interact in the public areas with other users, such information may be viewed by all users and may be publicly distributed outside. If You interact with other users or register through a Third-Party Social Media Service, Your contacts on the Third-Party Social Media Service may see Your name, profile, pictures and description of Your activity. Similarly, other users will be able to view descriptions of Your activity, communicate with You and view Your profile.\n" +
                "Retention of Your Personal Data\n" +
                "The Company will retain Your Personal Data only for as long as is necessary for the purposes set out in this Privacy Policy. We will retain and use Your Personal Data to the extent necessary to comply with our legal obligations (for example, if we are required to retain your data to comply with applicable laws), resolve disputes, and enforce our legal agreements and policies.\n" +
                "The Company will also retain Usage Data for internal analysis purposes. Usage Data is generally retained for a shorter period of time, except when this data is used to strengthen the security or to improve the functionality of Our Service, or We are legally obligated to retain this data for longer time periods.\n" +
                "Transfer of Your Personal Data\n" +
                "Your information, including Personal Data, is processed at the Company's operating offices and in any other places where the parties involved in the processing are located. It means that this information may be transferred to — and maintained on — computers located outside of Your state, province, country or other governmental jurisdiction where the data protection laws may differ than those from Your jurisdiction.\n" +
                "Your consent to this Privacy Policy followed by Your submission of such information represents Your agreement to that transfer.\n" +
                "The Company will take all steps reasonably necessary to ensure that Your data is treated securely and in accordance with this Privacy Policy and no transfer of Your Personal Data will take place to an organization or a country unless there are adequate controls in place including the security of Your data and other personal information.\n" +
                "Disclosure of Your Personal Data\n" +
                "Business Transactions\n" +
                "If the Company is involved in a merger, acquisition or asset sale, Your Personal Data may be transferred. We will provide notice before Your Personal Data is transferred and becomes subject to a different Privacy Policy.\n" +
                "Law enforcement\n" +
                "Under certain circumstances, the Company may be required to disclose Your Personal Data if required to do so by law or in response to valid requests by public authorities (e.g. a court or a government agency).\n" +
                "Other legal requirements\n" +
                "The Company may disclose Your Personal Data in the good faith belief that such action is necessary to:\n" +
                "•\tComply with a legal obligation\n" +
                "•\tProtect and defend the rights or property of the Company\n" +
                "•\tPrevent or investigate possible wrongdoing in connection with the Service\n" +
                "•\tProtect the personal safety of Users of the Service or the public\n" +
                "•\tProtect against legal liability\n" +
                "Security of Your Personal Data\n" +
                "The security of Your Personal Data is important to Us, but remember that no method of transmission over the Internet, or method of electronic storage is 100% secure. While We strive to use commercially acceptable means to protect Your Personal Data, We cannot guarantee its absolute security.\n" +
                "<h3><b>Your California Privacy Rights (California's Shine the Light law) </b></h3>\n" +
                "Under California Civil Code Section 1798 (California's Shine the Light law), California residents with an established business relationship with us can request information once a year about sharing their Personal Data with third parties for the third parties' direct marketing purposes.\n" +
                "If you'd like to request more information under the California Shine the Light law, and if you are a California resident, You can contact Us using the contact information provided below.\n" +
                "<h3><b>California Privacy Rights for Minor Users (California Business and Professions Code Section 22581) </b></h3>\n" +
                "California Business and Professions Code section 22581 allow California residents under the age of 18 who are registered users of online sites, services or applications to request and obtain removal of content or information they have publicly posted.\n" +
                "To request removal of such data, and if you are a California resident, You can contact Us using the contact information provided below, and include the email address associated with Your account.\n" +
                "Be aware that Your request does not guarantee complete or comprehensive removal of content or information posted online and that the law may not permit or require removal in certain circumstances.\n" +
                "<h3><b>Links to Other Websites</b></h3>\n" +
                "Our Service may contain links to other websites that are not operated by Us. If You click on a third party link, You will be directed to that third party's site. We strongly advise You to review the Privacy Policy of every site You visit.\n" +
                "We have no control over and assume no responsibility for the content, privacy policies or practices of any third party sites or services.\n" +
                "<h3><b>Changes to this Privacy Policy</b></h3>\n" +
                "We may update our Privacy Policy from time to time. We will notify You of any changes by posting the new Privacy Policy on this page.\n" +
                "We will let You know via email and/or a prominent notice on Our Service, prior to the change becoming effective and update the \"Last updated\" date at the top of this Privacy Policy.\n" +
                "You are advised to review this Privacy Policy periodically for any changes. Changes to this Privacy Policy are effective when they are posted on this page.\n" +
                "<h3><b>Contact Us</b></h3>\n" +
                "If you have any questions about this Privacy Policy, You can contact us:\n" +
                "•\tBy email: findermusician@gmail.com\n" +
                "Privacy Policy for Musician Finder\n" +
                "<br><br><br>" +
                "<b>Icons were made by:</b>" +
                "<ul>" +
                "<li><a href=\"https://www.flaticon.com/authors/iconixar\">iconixar</a></li>" +
                "<li><a href=\"https://www.flaticon.com/authors/freepik\">Freepik</a></li>" +
                "<li><a href=\"https://www.flaticon.com/authors/eucalyp\">Eucalyp</a></li>" +
                "<li><a href=\"https://www.flaticon.com/authors/pixel-perfect\">Pixel perfect</a></li>" +
                "<li><a href=\"https://www.flaticon.com/authors/surang\">surang</a></li>" +
                "<li><a href=\"https://www.flaticon.com/authors/gorbachev\">Gorbachev</a></li>" +
                "<li><a href=\"https://www.flaticon.com/authors/becris\">Becris</a></li>" +
                "<li><a href=\"https://www.flaticon.com/authors/ultimatearm\">ultimatearm</a></li>" +
                "<li><a href=\"https://www.flaticon.com/authors/smashicons\">Smashicons</a></li>" +
                "</ul>" +
                "from <a href=\"www.flaticon.com\">www.flaticon.com</a><br>" +
                "<a href=\"https://icons8.com/icons/set/sent\">Email Send icon</a> icon by " +
                "<a href=\"https://icons8.com\">Icons8</a>";
        return pp;
    }
    public String[] getGenres() {
        return genres;
    }
    public List<Instruments> getInstruments() {
        return instrumentsList;
    }
    public ArrayList<String> getInstrumentsArray() {
        return instrumentsArrayList;
    }
    public ArrayList<String> getCities() {
        return _cities;
    }
    public ArrayList<String> getGenresArrayList() {
        return genresArrayList;
    }
    public int getHeight() {
        return height;
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


