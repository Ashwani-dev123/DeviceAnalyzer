package com.example.githhubdemo.activity

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivitySecretCodeListBinding
import com.example.githhubdemo.adapter.CodeListAdapter
import com.example.githhubdemo.model.CodeModel
import com.example.githhubdemo.utils.ShareModule
import com.example.githhubdemo.utils.SharedPrefsUtilsModule
import com.example.githhubdemo.utils.Util


class SecretCodeListActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding : ActivitySecretCodeListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecretCodeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            window.decorView.setOnApplyWindowInsetsListener { view, insets ->
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    val statusBarHeight = insets.getInsets(WindowInsets.Type.statusBars()).top
                    view.setPadding(0, statusBarHeight, 0, 0)
                    view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorStatusBar))
                } else {
                    @Suppress("DEPRECATION")
                    window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)
                }

                insets
            }
        }
        else
        {
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)
        }

        if (Util.isNetworkConnected(this)) {
            if (SharedPrefsUtilsModule.getString(this, ShareModule.BANNER_ID,"") != "") {
                binding.bannerDashboard.loadBanner(this, SharedPrefsUtilsModule.getString(this, ShareModule.BANNER_ID,""))
            }
            else {
                binding.bannerDashboard.isVisible = false
            }
        }
        else {
            binding.bannerDashboard.isVisible = false
        }

        initListener()
        setListData()
    }

    private fun initListener() {
        binding.btnBack.setOnClickListener(this)
    }

    override fun onClick(view : View?) {
        when (view!!.id) {
            R.id.btnBack -> {
                onBackPressed()
            }
        }
    }

    private fun setListData() {
        val intExtra = intent.getStringExtra("keys")
        if (intExtra == "Samsung") {
            binding.tvToolbar.text = "Samsung"
            val arrayList = ArrayList<CodeModel>()
            arrayList.add(CodeModel("*#06#", "Display IMEI number."))
            arrayList.add(CodeModel("*#0*#", "General Test Mode."))
            arrayList.add(CodeModel("*#12580*369#", "Software & WH info."))
            arrayList.add(CodeModel("*#232337#", "Bluetooth Address Info."))
            arrayList.add(CodeModel("*#0588#", "Proximity Sensor Test Mode."))
            arrayList.add(CodeModel("*#273283*255*3282*#", "Data Create Menu."))
            arrayList.add(CodeModel("*#44336#", "Software Version Info."))
            arrayList.add(CodeModel("*#273283*255*663282*#", "Data Create SD Card."))
            arrayList.add(CodeModel("*#3282*727336*#", "Data Usage Status."))
            arrayList.add(CodeModel("*#232331#", "Bluetooth Test Mode."))
            arrayList.add(CodeModel("*#0782#", "Real Time Clock Test."))
            arrayList.add(CodeModel("*#0283#", "Audio Loopback Control."))
            arrayList.add(CodeModel("*#34971539#", "Camera Firmware Update."))
            arrayList.add(CodeModel("*#0526#", "WLAN Engineering Mode."))
            arrayList.add(CodeModel("*#746#", "Debug Dump Mode."))
            arrayList.add(CodeModel("*#1575#", "GPS Control Menu."))
            arrayList.add(CodeModel("*#3214789650#", "LBS Test Mode."))
            arrayList.add(CodeModel("*#745#", "RIL Dump Menu."))
            arrayList.add(CodeModel("*#03#", "NAND Flash S/N."))
            arrayList.add(CodeModel("*#0842#", "Vibra Motor Test Mode."))
            arrayList.add(CodeModel("*#*#1472365#*#*", "GPS Test Setting."))
            arrayList.add(CodeModel("*#*#197328640#*#*", "Service mode main Menu."))
            arrayList.add(CodeModel("*#0*#", "General Test Mode."))
            arrayList.add(CodeModel("*#0589#", "Light Sensor Test Mode."))
            arrayList.add(CodeModel("*#0673#", "Audio Test Mode."))
            arrayList.add(CodeModel("*#872564#", "USB Logging Control."))
            arrayList.add(CodeModel("*#4238378#", "GCF Configuration."))
            arrayList.add(CodeModel("*#7594#", "Remap Shut Down To End Call Task."))
            arrayList.add(CodeModel("*#0289#", "Melody Test Mode."))
            arrayList.add(CodeModel("*#*#34971539#*#*", "Camera Firware Menu."))
            arrayList.add(CodeModel("*#80#", "Unknown."))
            arrayList.add(CodeModel("*#3214789#", "GCF Mode Status."))
            arrayList.add(CodeModel("*#272886#", "Auto Answer Selection."))
            arrayList.add(CodeModel("*#232339#", "WLAN Test Mode."))
            arrayList.add(CodeModel("*2767*3855#", "ROM Firmware Default Setting."))
            arrayList.add(CodeModel("*#272*HHMM#", "Change/Display CSS Code."))
            arrayList.add(CodeModel("*2767*4387264636#", "To Display Product Code"))
            arrayList.add(CodeModel("*#272*imei#", "Change/Display CSS Code."))
            arrayList.add(CodeModel("*#2663#", "TPS/TSK Firmware Update."))
            arrayList.add(CodeModel("*#528#", "WLAN Engineering Mode"))
            arrayList.add(CodeModel("*#7412365#", "Camera Firware Menu."))
            arrayList.add(CodeModel("*#07#", "Test History."))
            arrayList.add(CodeModel("*#8736364#", "OTA Update Menu."))
            arrayList.add(CodeModel("*#301279#", "HSDPA/HSUPA Control menu."))
            arrayList.add(CodeModel("*#7353#", "Quick Test Menu."))
            arrayList.add(CodeModel("*2767*4387264636#", "Sellout SMS/PCODE View."))
            arrayList.add(CodeModel("*#7465625#", "View Phone Lock Status."))
            arrayList.add(CodeModel("*#7284#", "USB I2C Mode Control."))
            arrayList.add(CodeModel("*#232339#", "WLAN Test Mode."))
            arrayList.add(CodeModel("*2767*3855#", "ROM Firmware Default Setting."))
            arrayList.add(CodeModel("*2767*4387264636#", "To Display Product Code"))
            arrayList.add(CodeModel("*#272*imei#", "Change/Display CSS Code."))
            arrayList.add(CodeModel("*#*#3636#*#*", "General Setting Mode."))
            arrayList.add(CodeModel("*#*#7780#*#*", "Factory Soft Reset."))
            arrayList.add(CodeModel("*#*#1472365#*#*", "GPS Test Settings."))
            arrayList.add(CodeModel("*#7465625*782*#", "Configure Network Lock NSp"))
            arrayList.add(CodeModel("*#7465625*27*#", "Inset NetworkLock keycode NSp/CP."))
            arrayList.add(CodeModel("*#232338#", "WLAN MAC Address."))
            arrayList.add(CodeModel("*#272*HHMM#", "Change/Display CSS Code."))
            arrayList.add(CodeModel("*#7465625*77*#", "Insert Operator Lock Keycode."))
            arrayList.add(CodeModel("*7465625*638*#", "Configure Network Lock MCC/MNC."))
            arrayList.add(CodeModel("*#7465625*638*#", "Insert Network Keycode."))
            arrayList.add(CodeModel("*#0228#", "ADC Reading."))
            arrayList.add(CodeModel("*#7465625*27*#", "Insert Content Provider Keycode."))
            arrayList.add(CodeModel("*#7465625*782*#", "Insert Partial Network Lock Keycode."))
            arrayList.add(CodeModel("*#7465625*77*#", "Insert Network Lock Keycode SP."))
            arrayList.add(CodeModel("*#2263#", "RF Band Selection."))
            arrayList.add(CodeModel("*#9090#", "Diagnostic Configuration."))
            binding.lvCodeList.adapter = CodeListAdapter(arrayList, this)
        }
        else if (intExtra == "Htc") {
            binding.tvToolbar.text = "HTC"
            val arrayList2 = ArrayList<CodeModel>()
            arrayList2.add(CodeModel("*#06#", "Display IMEI number."))
            arrayList2.add(CodeModel("#*#4636#*#*", "Device information program"))
            arrayList2.add(CodeModel("*#*#7262626#*#*", "Field test"))
            arrayList2.add(CodeModel("*#*#3424#*#*", "HTC function test program"))
            arrayList2.add(CodeModel("*#*#1111#*#*", "Display software information."))
            arrayList2.add(CodeModel("*#*#1472365#*#*", "GPS Test 2"))
            arrayList2.add(CodeModel("*#*#232331#*#*", "Bluetooth test"))
            arrayList2.add(CodeModel("*#*#0*#*#*", "Display test"))
            arrayList2.add(CodeModel("*#*#2663#*#*", "Touch Screen version"))
            arrayList2.add(CodeModel("*#*#2664#*#*", "Touch Screen Test"))
            arrayList2.add(CodeModel("#*#759#*#*", "Debug UI"))
            arrayList2.add(CodeModel("*2767*3855#", "Factory format"))
            arrayList2.add(CodeModel("*#*#4636#*#*", "Testing menu"))
            arrayList2.add(CodeModel("*#*#4636#*#*", "Display info about device"))
            arrayList2.add(CodeModel("*#*#7*#*#34971539#*#*", "Camera information"))
            arrayList2.add(CodeModel("*#*#1472365#*#*", "Short GPS test."))
            arrayList2.add(CodeModel("*#*#197328640#*#*", "Service activity test mode"))
            arrayList2.add(CodeModel("*#*#232338#*#*", "Wi-Fi Mac address"))
            arrayList2.add(CodeModel("*#*#0842#*#*", "Vibration and backlight test "))
            arrayList2.add(CodeModel("*#*#2663#*#*", "Check touch screen version"))
            arrayList2.add(CodeModel("*#*#0*#*#*", "LCD test"))
            arrayList2.add(CodeModel("*#*#2664#*#*", "Touch screen test "))
            arrayList2.add(CodeModel("*#*#0588#*#*", "Proximity sensor test"))
            arrayList2.add(CodeModel("*#*#3264#*#*", "RAM information"))
            arrayList2.add(CodeModel("##3384#", "For trial Menu."))
            arrayList2.add(CodeModel("##786#", "Reverse Logistic Support."))
            arrayList2.add(CodeModel("##3424#", "Diagnostic mode."))
            arrayList2.add(CodeModel("*#*#2222#*#*", "Display hardware version"))
            arrayList2.add(CodeModel("*#*#232338#*#*", "Wi-Fi Mac address"))
            arrayList2.add(CodeModel("*#*#232337#*#*", "Bluetooth Mac address"))
            arrayList2.add(CodeModel("##7738#", "Protocol Revision."))
            arrayList2.add(CodeModel("*#*#4636#*#*", "Htc Info Menu."))
            arrayList2.add(CodeModel("*#*#8255#*#*", "Launches GTalk Service Monitor."))
            arrayList2.add(CodeModel("*#*#1472365#*#*", "GPS Test"))
            arrayList2.add(CodeModel("*#*#232331#*#*", "Bluetooth test"))
            arrayList2.add(CodeModel("*2767*3855#", "Reinstall the firmware"))
            arrayList2.add(CodeModel("*#872564#", "USB logging control "))
            arrayList2.add(CodeModel("*#746#", "Debug dump menu."))
            arrayList2.add(CodeModel("*#*#2434#*#*", "Htc Function test program."))
            arrayList2.add(CodeModel("##3282#", "For EPST."))
            arrayList2.add(CodeModel("##8626337#", "For Vocoder."))
            arrayList2.add(CodeModel("##3384#", "For trial Menu."))
            arrayList2.add(CodeModel("##786#", "Reverse Logistic Support."))
            binding.lvCodeList.adapter = CodeListAdapter(arrayList2, this)
        }
        else {
            val str = "*#*#7780#*#*"
            val str2 = "*#*#0842#*#*"
            val str3 = "*#0*#"
            val str4 = "*#*#197328640#*#*"
            val str5 = "*2767*3855#"
            val str6 = "Wireless LAN Tests."
            val str7 = "*#*#232339#*#*"
            val str8 = "Enables Subset lock"
            val str9 = "*#*#34971539#*#*"
            val str10 = "*#*#2222#*#*"
            val str11 = "*#*#1111#*#*"
            val str12 = "*#*#1234#*#*"
            val str13 = "*#*#232331#*#*"
            val str14 = "*#*#3264#*#*"
            val str15 = "*#*#1472365#*#*"
            if (intExtra == "Sony") {
                binding.tvToolbar.text = "Sony"
                val arrayList3 = ArrayList<CodeModel>()
                arrayList3.add(CodeModel("*#06#", "Display IMEI number."))
                arrayList3.add(CodeModel("*#*#225#*#*", "Events calendar."))
                arrayList3.add(CodeModel("*#*#426#*#*", "Debug information for Google Play service"))
                arrayList3.add(CodeModel("*#872564#", "USB logging control"))
                arrayList3.add(CodeModel("*#9900#", "System dump mode Sony Xperia M"))
                arrayList3.add(CodeModel("*#*#97#*#*", "Language and Keyboard settings in Sony Xperia M"))
                arrayList3.add(CodeModel("*#*#46*#*#", "Reset Sim in Sony Xperia M"))
                arrayList3.add(CodeModel("#7465625*77*Code#", "Disables SP lock"))
                arrayList3.add(CodeModel("*7465625*27*Code#", "Enables CP lock"))
                arrayList3.add(CodeModel("#7465625*27*Code#", "Disables CP lock "))
                arrayList3.add(CodeModel("#7465625*746*Code#", "Disables SIM lock"))
                arrayList3.add(CodeModel("7465625*746*Code#", "Enables SIM lock "))
                arrayList3.add(CodeModel("*7465625*228#", "Activa lock ON "))
                arrayList3.add(CodeModel("#7465625*228#", "Activa lock OFF"))
                arrayList3.add(CodeModel("*#*#0283#*#*", "Packet Loopback."))
                arrayList3.add(CodeModel("*#*#0*#*#*", "LCD display test "))
                arrayList3.add(CodeModel("*#*#0673#*#*", "Melody test "))
                arrayList3.add(CodeModel("*#*#2664#*#*", "Touch screen test "))
                arrayList3.add(CodeModel("*#*#0588#*#*", "Proximity sensor test "))
                arrayList3.add(CodeModel("*#06#", "Display IMEI number."))
                arrayList3.add(CodeModel("*#7465625#", "View phone lock status "))
                arrayList3.add(CodeModel("*7465625*638*Code#", "Enables Network lock"))
                arrayList3.add(CodeModel("#7465625*638*Code#", "Disables Network lock"))
                arrayList3.add(CodeModel("*7465625*782*Code#", "Enables Subset lock"))
                arrayList3.add(CodeModel("#7465625*782*Code#", "Disables Subset lock"))
                arrayList3.add(CodeModel("*7465625*77*Code#", "Enables SP lock "))
                arrayList3.add(CodeModel("*#*#*7378423#*#*", "Service Test, Pressure Sensor."))
                arrayList3.add(CodeModel("*#*#46360#*#*", "Acess phone Information."))
                arrayList3.add(CodeModel("*#*#232339#*#*", "Wireless LAN Tests."))
                arrayList3.add(CodeModel("*#*#526#*#*", "Wireless LAN Tests."))
                arrayList3.add(CodeModel("*#*#528#*#*", "Wireless LAN Tests."))
                arrayList3.add(CodeModel("*2767*3855#", "Factory reset on Xperia Z.."))
                arrayList3.add(CodeModel("*#*#34971539#*#*", "Shows Complete Information about the Camera."))
                arrayList3.add(CodeModel("*#*#197328640#*#*", "Enable test mode for Service Activity."))
                arrayList3.add(CodeModel("*#*#273283*255*663282#*#*", "For Quick Backup to your Media Files."))
                arrayList3.add(CodeModel("*#*#232338#*#*", "Used to Display Wi-Fi Mac-address."))
                arrayList3.add(CodeModel("*#*#1472365#*#*", "Used for a quick GPS Test."))
                arrayList3.add(CodeModel("*#*#1575#*#*", "For another different type of GPS test."))
                arrayList3.add(CodeModel("*#*#0283#*#*", "Packet Loopback Test."))
                arrayList3.add(CodeModel("*#*#0#*#*", "LCD Display Test."))
                arrayList3.add(CodeModel("*#*#0588#*#*", "Proximity Sensor test."))
                arrayList3.add(CodeModel("*#*#3264#*#*", "RAM Version."))
                arrayList3.add(CodeModel("*#*#232331#*#*", "Bluetooth Testing."))
                arrayList3.add(CodeModel("*#*#0673#*#*", "To Test Audio of Xperia U."))
                arrayList3.add(CodeModel("*#*#0289#*#*", "To Test Audio of Xperia U."))
                arrayList3.add(CodeModel("*#*#2663#*#*", "Display Touch Screen Version."))
                arrayList3.add(CodeModel("*#*#7262626#*#*", "Field Test."))
                arrayList3.add(CodeModel("*#*#232337#*#*", "Display Bluetooth Device Address."))
                arrayList3.add(CodeModel("*#*#8255#*#*", "For Google Talk Service Monitoring."))
                arrayList3.add(CodeModel("*#*#4986*2650468#*#*", "Hardware, Phone,PDA,RF Call Date firmware informations."))
                arrayList3.add(CodeModel("*#*#1234#*#*", "PDA and Phone Firmware Information."))
                arrayList3.add(CodeModel("*#*#1111#*#*", "FTA Software Version."))
                arrayList3.add(CodeModel("*#*#8350#*#*", "Disable Voice Dialing Mode."))
                arrayList3.add(CodeModel("*#*#05#*#*", "Execute from Emergency dial Screen to unlock PUK code."))
                arrayList3.add(CodeModel("*#*#7378423#*#*", "Pressure Sensor, Service Test."))
                arrayList3.add(CodeModel("*#*#2222#*#*", "FTA Hardware Version."))
                arrayList3.add(CodeModel("*#*#44336#*#*", "Display Build Time and change list number."))
                arrayList3.add(CodeModel("*#*#8351#*#*", "Enable Voice Dialing Mode."))
                binding.lvCodeList.adapter = CodeListAdapter(arrayList3, this)
            }
            val str17 = "*#*#225#*#*"
            val str18 = str4
            val str19 = str6
            val str20 = str7
            val str21 = str9
            val str22 = str10
            val str23 = str11
            val str24 = str12
            val str25 = str13
            val str26 = str14
            val str27 = str15
            val str28 = "*#872564#"
            val str29 = str5
            val str30 = str8
            val str31 = "*#7465625#"
            if (intExtra == "Lenovo") {
                binding.tvToolbar.text = "Lenovo"
                val arrayList4 = ArrayList<CodeModel>()
                arrayList4.add(CodeModel("*#06#", "Display IMEI number."))
                arrayList4.add(CodeModel("####1040#", "Check Network status information,View Local CELL lane rxlev."))
                arrayList4.add(CodeModel("####0000#", "Check phone Software Version."))
                arrayList4.add(CodeModel("####2222#", "lookup Cell Phone SN as 6162."))
                arrayList4.add(CodeModel("####11#", "Network time syuchronization."))
                arrayList4.add(CodeModel("####1001#", "Unicom network lock feature."))
                arrayList4.add(CodeModel("*7465625*638*Code#", "Enables Network lock"))
                arrayList4.add(CodeModel("#7465625*638*Code#", "Disables Network lock"))
                arrayList4.add(CodeModel("*7465625*782*Code#", "Enables Subset lock"))
                arrayList4.add(CodeModel("#7465625*782*Code#", "Disables Subset lock"))
                arrayList4.add(CodeModel("*7465625*77*Code#", "Enables SP lock "))
                arrayList4.add(CodeModel("#7465625*77*Code#", "Disables SP lock"))
                arrayList4.add(CodeModel("*7465625*27*Code#", "Enables CP lock"))
                arrayList4.add(CodeModel("*#*#0*#*#*", "LCD display test "))
                arrayList4.add(CodeModel("*#*#0673#*#*", "Melody test "))
                arrayList4.add(CodeModel("*#*#2664#*#*", "Touch screen test "))
                arrayList4.add(CodeModel("*#*#0588#*#*", "Proximity sensor test "))
                arrayList4.add(CodeModel("*#06#", "Display IMEI number."))
                arrayList4.add(CodeModel("*#0000#", "Query Software kernel version as AE23 AE06."))
                arrayList4.add(CodeModel("####10086#", "Mobile Network Lock Feature."))
                arrayList4.add(CodeModel("####4444#", "Phone automatically restart."))
                arrayList4.add(CodeModel("####88**#", "Right Function MONTERNET and players to switch between."))
                arrayList4.add(CodeModel("####1111#", "Screen Colors."))
                arrayList4.add(CodeModel("####7777#", "Phone restore factory settings."))
                arrayList4.add(CodeModel("*#*#*7378423#*#*", "Service Test, Pressure Sensor."))
                arrayList4.add(CodeModel("*#*#46360#*#*", "Acess phone Information."))
                arrayList4.add(CodeModel("*#*#232339#*#*", str19))
                arrayList4.add(CodeModel("*#*#526#*#*", str19))
                arrayList4.add(CodeModel("*#*#528#*#*", str19))
                arrayList4.add(CodeModel("#7465625*27*Code#", "Disables CP lock "))
                arrayList4.add(CodeModel("#7465625*746*Code#", "Disables SIM lock"))
                arrayList4.add(CodeModel("7465625*746*Code#", "Enables SIM lock "))
                arrayList4.add(CodeModel("*7465625*228#", "Activa lock ON "))
                arrayList4.add(CodeModel("#7465625*228#", "Activa lock OFF"))
                binding.lvCodeList.adapter = CodeListAdapter(arrayList4, this)
            }
            else if (intExtra == "Blackberry") {
                binding.tvToolbar.text = "BLACKBERRY"
                val arrayList5 = ArrayList<CodeModel>()
                arrayList5.add(CodeModel("*#9900#", "Sysdump screen."))
                arrayList5.add(
                    CodeModel(
                        str29,
                        "Factory Data Wipe And internal SD Resets soon as you enter #."
                    )
                )
                arrayList5.add(CodeModel("*#8255#", "For G Talk service monitor."))
                arrayList5.add(CodeModel("*#7780#", "For Factory data reset."))
                arrayList5.add(CodeModel("*#7594#", "Change Power button option in your Phone."))
                arrayList5.add(CodeModel("*#197328640#", "Service Mode."))
                arrayList5.add(
                    CodeModel(
                        "*#0011#",
                        "Show Network mode/ Power info hidden menu/cell info."
                    )
                )
                arrayList5.add(
                    CodeModel(
                        "*#4636#",
                        "Show Battery and other general settings like GSM/CDMA."
                    )
                )
                arrayList5.add(CodeModel("*#1472365#", "GPS Test."))
                arrayList5.add(CodeModel(str3, "Testing Mode."))
                arrayList5.add(CodeModel(str31, "Engineering Mode."))
                arrayList5.add(CodeModel("*#3214789650#", "GPS Service Menu."))
                arrayList5.add(CodeModel("*#34971539#", "For Information about camera."))
                arrayList5.add(CodeModel("*#1234#", "Display phones current firmware."))
                binding.lvCodeList.adapter = CodeListAdapter(arrayList5, this)
            } else {
                val str32 = str29
                val str33 = str19
                val str34 = str3
                val str35 = "7465625*746*Code#"
                val str36 = str31
                val str37 = "Disables SIM lock"
                val str38 = "#7465625*638*Code#"
                if (intExtra == "Motorola") {
                    binding.tvToolbar.text = "MOTOROLA"
                    val arrayList6 = ArrayList<CodeModel>()
                    arrayList6.add(CodeModel("*#06#", "Display IMEI number."))
                    arrayList6.add(CodeModel(str34, "Service menu"))
                    arrayList6.add(CodeModel("*#9090#", "Diagnostic configuration"))
                    arrayList6.add(CodeModel("*#*#2664#*#*", "Test the touchscreen"))
                    arrayList6.add(CodeModel(str36, "View phone lock status"))
                    arrayList6.add(CodeModel("*#9900#", "System dump mode"))
                    arrayList6.add(CodeModel(str23, "FTA SW Version"))
                    arrayList6.add(CodeModel(str22, "FTA HW Version"))
                    arrayList6.add(CodeModel("*#301279#", "HSDPA/HSUPA Control"))
                    val str39 = str28
                    arrayList6.add(CodeModel(str39, "USB logging control Menu"))
                    arrayList6.add(CodeModel("##7764726", "Hidden service menu"))
                    arrayList6.add(CodeModel("*#302#", "OK Accoustict test"))
                    arrayList6.add(CodeModel("*#3370#", "Enhanced full rate"))
                    arrayList6.add(CodeModel("*#0000#", "OK Settings saved"))
                    arrayList6.add(CodeModel("*#307#", "OK Engineering test mode"))
                    arrayList6.add(CodeModel("*#*#786#*#*", "Moto G Hard Reset"))
                    arrayList6.add(CodeModel("*#*#2432546#*#*", "Manual Check Update"))
                    arrayList6.add(CodeModel(str39, "USB logging control,"))
                    arrayList6.add(CodeModel("*#9090#", "Diagnostic configuration"))
                    arrayList6.add(CodeModel(str20, "Wireless LAN tests"))
                    arrayList6.add(CodeModel(str2, "Backlight/vibration test"))
                    arrayList6.add(CodeModel("*#*#4636#*#*", "Display phone information"))
                    arrayList6.add(CodeModel(str, "Reset phone factory data reset"))
                    arrayList6.add(CodeModel(str32, "Format device to factory reset"))
                    arrayList6.add(
                        CodeModel(
                            "*#*#273282*255*663282*#*#*",
                            "Backup of all media files"
                        )
                    )
                    arrayList6.add(CodeModel(str18, "Enable test mode for service"))
                    val str40 = str24
                    arrayList6.add(CodeModel(str40, "Super Mode."))
                    arrayList6.add(CodeModel("*#*#7873778#*#*", "Super user App."))
                    arrayList6.add(CodeModel("*#*#2486#*#*", "Service Menu."))
                    arrayList6.add(CodeModel(str40, "Super user App."))
                    arrayList6.add(CodeModel("*#*#2432546#*#*", "Check update."))
                    binding.lvCodeList.adapter = CodeListAdapter(arrayList6, this)
                }
                val str41 = str28
                val str42 = str18
                val str43 = str22
                val str44 = str23
                val str45 = str24
                val str46 = str
                val str47 = str46
                val str48 = str47
                if (intExtra == "Lg") {
                    binding.tvToolbar.text = "LG"
                    val arrayList7 = ArrayList<CodeModel>()
                    arrayList7.add(CodeModel("*#06#", "Display IMEI number."))
                    arrayList7.add(CodeModel("*#07#", "Displays the IMEI and Software Version"))
                    arrayList7.add(CodeModel("*#07#", "IMEI and Software number."))
                    arrayList7.add(CodeModel("*8375#", "Software version on B1200."))
                    arrayList7.add(CodeModel("9270#", "Works on very old lG Phones."))
                    arrayList7.add(CodeModel("*6861#", "Recount checksum on B1200."))
                    arrayList7.add(CodeModel("8060#", "Works on very old lG Phones."))
                    arrayList7.add(CodeModel("3845#*XXXX#", "Secret menu Code for newer LG's."))
                    arrayList7.add(
                        CodeModel(
                            "2945#*#",
                            "It works on most of the LG phones without Sim Card ."
                        )
                    )
                    arrayList7.add(CodeModel("47328545454#", "Service menu code for U8130."))
                    arrayList7.add(CodeModel("47328545454#", "Service menu code for U8138."))
                    arrayList7.add(CodeModel("47328545454#", "Service menu code for U8180."))
                    arrayList7.add(CodeModel("637664#*#", "Service menu code for U8330."))
                    arrayList7.add(CodeModel("*6*41*12##", "Service menu code for U8360."))
                    arrayList7.add(CodeModel("885508428679#*#", "Service menu code for U8550."))
                    arrayList7.add(CodeModel("142358#*#", "Service menu code for U890 and U880."))
                    arrayList7.add(CodeModel("082065#*#", "Service menu code for U900."))
                    arrayList7.add(CodeModel("1945#*5101#", "Secret menu for older LG's."))
                    arrayList7.add(CodeModel("2945#*5101#", "Secret menu for older LG's."))
                    arrayList7.add(CodeModel("1945#*70001#", "Secret menu for older LG's."))
                    arrayList7.add(CodeModel("#PWR 668", "Initiates a Factory test of phone"))
                    arrayList7.add(CodeModel("2945#*#", "Enter the Test Screen"))
                    arrayList7.add(CodeModel("2945*#01*#", "Opens a secret menu"))
                    arrayList7.add(CodeModel("1945#*5101#", "Unlock B1200 CodeModel"))
                    arrayList7.add(CodeModel("2945#*5101#", "Unlock 5200 & 510W CodeModel"))
                    arrayList7.add(CodeModel("2945#*70001#", "Unlock 7020 & 7010 CodeModel"))
                    arrayList7.add(CodeModel("2947#*", "Unlock 500 & 600 CodeModel"))
                    arrayList7.add(CodeModel("2945#*88110#", "Access the LG unlock menu"))
                    arrayList7.add(CodeModel("1809#*#900#", "Secret code for KM900."))
                    arrayList7.add(CodeModel("277634#*#", "Code for U8110, U8120 and KU800 etc."))
                    arrayList7.add(CodeModel("9278#", "Works on very old lG Phones."))
                    arrayList7.add(
                        CodeModel(
                            "1809#*Code#",
                            "Service menu code=phone name e,g 1809#*360# for KS360."
                        )
                    )
                    arrayList7.add(CodeModel("1809#*500#", "Secret menu for K500, K501 and K502."))
                    arrayList7.add(CodeModel("525252#*#", "Service menu code for U8380."))
                    arrayList7.add(CodeModel("2947#*", "Secret menu for very old Lg's."))
                    arrayList7.add(CodeModel("3845#*920#", "Secret menu for LG P920 Optimus 3D."))
                    binding.lvCodeList.adapter = CodeListAdapter(arrayList7, this)
                }
                val str49 = str32
                if (intExtra == "Oppo") {
                    binding.tvToolbar.text = "Oppo"
                    val arrayList8 = ArrayList<CodeModel>()
                    arrayList8.add(CodeModel("*#06#", "Display IMEI number."))
                    arrayList8.add(CodeModel(str48, "Factory reset"))
                    arrayList8.add(CodeModel("#*#4636#*#*", "OppoF1 Phone information "))
                    arrayList8.add(CodeModel("#*#4636#*#*", "Oppo F1 Usage statistics "))
                    arrayList8.add(CodeModel(str17, "Events calendar. "))
                    arrayList8.add(
                        CodeModel(
                            "*#*#426#*#*",
                            "Debug information for Google Play service"
                        )
                    )
                    arrayList8.add(CodeModel("*7465625*782*Code#", str30))
                    arrayList8.add(CodeModel("#7465625*782*Code#", "Disables Subset lock"))
                    arrayList8.add(CodeModel("*7465625*77*Code#", "Enables SP lock "))
                    arrayList8.add(CodeModel("#7465625*77*Code#", "Disables SP lock "))
                    arrayList8.add(CodeModel("*7465625*27*Code#", "Enables CP lock "))
                    arrayList8.add(CodeModel("#7465625*27*Code#", "Disables CP lock "))
                    arrayList8.add(CodeModel("*7465625*746*Code#", "Enables SIM lock "))
                    arrayList8.add(CodeModel("#7465625*746*Code#", "Disables SIM lock "))
                    arrayList8.add(CodeModel("*7465625*228#", "Active lock ON"))
                    arrayList8.add(CodeModel("#7465625*228#", "Active lock OFF "))
                    arrayList8.add(CodeModel("*7465625*28638#", "Auto Network lock ON "))
                    arrayList8.add(CodeModel("#7465625*28638#", "Auto Network lock OFF "))
                    arrayList8.add(
                        CodeModel(
                            "*#*#426#*#*",
                            "Debug information for Google Play service"
                        )
                    )
                    arrayList8.add(CodeModel("*#*#759#*#*", "Access Google Partner setup"))
                    arrayList8.add(CodeModel("*#872564# ", "USB logging control"))
                    arrayList8.add(CodeModel("#*#4636#*#*", "Oppo F1 Battery information "))
                    arrayList8.add(CodeModel("#*#4636#*#*", "Oppo F1 Battery history "))
                    arrayList8.add(CodeModel("*#9900#", " System dump mode OPPO F1s"))
                    arrayList8.add(CodeModel(str36, "View phone lock status "))
                    arrayList8.add(CodeModel("*7465625*638*Code#", "Enables Network lock "))
                    arrayList8.add(CodeModel(str38, "Disables Network lock "))
                    arrayList8.add(CodeModel("*7465625*28782#", "Auto subset lock ON"))
                    arrayList8.add(CodeModel("#7465625*28782#", "Auto subset lock OFF "))
                    arrayList8.add(CodeModel("*7465625*2877#", "Auto SP lock ON"))
                    arrayList8.add(CodeModel("#7465625*2877#", "Auto SP lock OFF "))
                    arrayList8.add(CodeModel("*7465625*2827#", "Auto CP lock ON "))
                    arrayList8.add(CodeModel("#7465625*2827#", "Auto CP lock OFF "))
                    arrayList8.add(CodeModel(str20, "WLAN test"))
                    arrayList8.add(CodeModel("*#*#526#*#*", "WLAN test"))
                    arrayList8.add(CodeModel("*#*#528#*#*", "WLAN test"))
                    arrayList8.add(CodeModel("*#*#1575#*#*", "For a more advanced GPS test"))
                    arrayList8.add(CodeModel("*#*#0283#*#*", "Packet Loopback"))
                    arrayList8.add(CodeModel("*#*#0*#*#*", "LCD display test "))
                    arrayList8.add(CodeModel("*#1234#", "View Software Details."))
                    arrayList8.add(CodeModel("*#36446337#", "Test Function Instruction."))
                    arrayList8.add(CodeModel("*#804#", "Automatically disconnect test mode."))
                    arrayList8.add(CodeModel("*#805#", "Engineering Bluetooth test mode."))
                    arrayList8.add(CodeModel("*#*#2664#*#*", "Touch screen test "))
                    arrayList8.add(CodeModel("*#*#0588#*#*", "Proximity sensor test "))
                    arrayList8.add(CodeModel(str26, "RAM version OPPO F1s "))
                    arrayList8.add(CodeModel("*#800#", "Enter engineering mode."))
                    arrayList8.add(CodeModel("*#888#", "View hardware pch version."))
                    arrayList8.add(CodeModel("*#900#", "Test Photograph RGB."))
                    arrayList8.add(CodeModel("*#99#", "Screen lights long bright."))
                    arrayList8.add(CodeModel("*#801#", "Engineering switch test mode."))
                    arrayList8.add(CodeModel("*#802#", "TTFF GPS test mode."))
                    arrayList8.add(CodeModel("*#803#", "Enter engineering network test mode."))
                    arrayList8.add(CodeModel("*#808#", "Enter manual engineering test mode."))
                    arrayList8.add(CodeModel("*#809#", "Enter engineering echo test mode."))
                    arrayList8.add(CodeModel("*#6776#", "Machine Information."))
                    arrayList8.add(CodeModel("*#806#", "Enter aging test mode."))
                    arrayList8.add(CodeModel("*#807#", "Enter engineering test mode."))
                    binding.lvCodeList.adapter = CodeListAdapter(arrayList8, this)
                    return
                }
                val str50 = str30
                val str51 = str38
                val str52 = str17
                val str53 = "*7465625*228#"
                val str54 = "Disables CP lock "
                val str55 = str26

                if (intExtra == "Qmobile") {
                    binding.tvToolbar.text = "QMOBILE"
                    val arrayList9 = ArrayList<CodeModel>()
                    arrayList9.add(CodeModel("*#06#", "Display IMEI number."))
                    arrayList9.add(CodeModel("*#07#", "IMEI and SW (Q Mobile 510)."))
                    arrayList9.add(CodeModel("*8375#", "Software version (Q Mobile B1200)."))
                    arrayList9.add(CodeModel("277634#*#", "Test menu 8110,8120."))
                    arrayList9.add(CodeModel("49857465454#", "Test menu 8180 V10a."))
                    arrayList9.add(CodeModel("492662464663#", "Test menu 8180 V11a."))
                    arrayList9.add(CodeModel("47328545454#", "Test menu 8130,8138."))
                    arrayList9.add(CodeModel("*6861#", "Recount checksum (Q Mobile B1200)."))
                    arrayList9.add(CodeModel("#PWR 668", "Factory test (Q Mobile B1200)."))
                    arrayList9.add(CodeModel("1845#*501#", "Simlock menu (Q Mobile B1200)."))
                    arrayList9.add(CodeModel("2945#*51013", "Simlock menu (Q Mobile 510W,5200)."))
                    arrayList9.add(CodeModel("637664#*#", "Test menu 8310."))
                    binding.lvCodeList.adapter = CodeListAdapter(arrayList9, this)
                }
                else if (intExtra == "Chaina") {
                    binding.tvToolbar.text = "CHINA"
                    val arrayList10 = ArrayList<CodeModel>()
                    arrayList10.add(CodeModel("*#06#", "Display IMEI number."))
                    arrayList10.add(CodeModel("*#110*01#", "Enter into Engineering Mode."))
                    arrayList10.add(CodeModel("*#0000#", "Set Default Language."))
                    arrayList10.add(CodeModel("*#0007#", "Set Language to Russian."))
                    arrayList10.add(CodeModel("*#0033#", "Set Language to French."))
                    arrayList10.add(CodeModel("*#900#", "Check Software Version."))
                    arrayList10.add(CodeModel("*#800#", "Check Software Version."))
                    arrayList10.add(
                        CodeModel(
                            "*#4960#",
                            "Send to view Information about Mobile phone."
                        )
                    )
                    arrayList10.add(CodeModel("*#8140#", "Send Used for NET lock."))
                    arrayList10.add(CodeModel("*#1110#", "Send For Special NET lock."))
                    arrayList10.add(CodeModel("*#987#", "Enter into factory Mode."))
                    arrayList10.add(CodeModel("*#987*99#", "Restore factory Setting."))
                    arrayList10.add(CodeModel("*#0034#", "Set Language to Spanish."))
                    arrayList10.add(CodeModel("*#0039#", "Set Language to Italian."))
                    arrayList10.add(CodeModel("*#0084#", "Set Language to Vietname."))
                    arrayList10.add(CodeModel("*#0966#", "Set Language to Arabic."))
                    arrayList10.add(CodeModel("*#2634#", "Send For Unlock GPRS Settings."))
                    arrayList10.add(CodeModel("*73738#", "Send For Reset the Hardware parts."))
                    arrayList10.add(CodeModel("*#0044#", "Set Language to English."))
                    arrayList10.add(CodeModel("*#0049#", "Set Language to German."))
                    arrayList10.add(CodeModel("*#0066#", "Set Language to Thai."))
                    binding.lvCodeList.adapter = CodeListAdapter(arrayList10, this)
                } else {
                    val str56 = "*7465625*27*Code#"
                    if (intExtra == "GENERIC") {
                        binding.tvToolbar.text = "GENERIC"
                        val arrayList11 = ArrayList<CodeModel>()
                        arrayList11.add(CodeModel("*#06#", "Display IMEI number."))
                        arrayList11.add(
                            CodeModel(
                                "*#*#4636#*#*",
                                "Displayn information about Phone,Battery and Usage Statics."
                            )
                        )
                        arrayList11.add(CodeModel(str27, "For a quick GPS Test."))
                        arrayList11.add(CodeModel("*#*#1575#*#*", "A Different type GPS Test."))
                        arrayList11.add(
                            CodeModel(
                                str48,
                                "Resetting your Phone to factory state,only deletes application data."
                            )
                        )
                        arrayList11.add(CodeModel(str49, "Its a complete wiping of your mobile."))
                        arrayList11.add(
                            CodeModel(
                                str21,
                                "Shows completes informations about tghe camera."
                            )
                        )
                        arrayList11.add(CodeModel("*#*#0283#*#*", "Packet loopback Test."))
                        arrayList11.add(CodeModel("*#*#0#*#*", "LCD Display Test."))
                        arrayList11.add(CodeModel(str2, "Vibration and Backlight test."))
                        arrayList11.add(CodeModel("*#*#2663#*#*", "Display touch-screen version."))
                        arrayList11.add(CodeModel("*#*#2664#*#*", "Touch Screen Test."))
                        arrayList11.add(CodeModel("*#*#0588#*#*", "Proximity Sensor Test."))
                        arrayList11.add(CodeModel(str55, "RAM version."))
                        arrayList11.add(CodeModel(str25, "Bluetooth Test."))
                        arrayList11.add(CodeModel(str20, "Wireless Lan Tests."))
                        arrayList11.add(CodeModel("*#*#526#*#*", "Wireless Lan Tests."))
                        arrayList11.add(CodeModel("*#*#232338#*#*", "Display Wi-Fi mac-address."))
                        arrayList11.add(
                            CodeModel(
                                "*#*#7594#*#*",
                                "Changing the power button behaviour."
                            )
                        )
                        arrayList11.add(
                            CodeModel(
                                "*#*#273283*255*663282#*#*",
                                "For a quick backup to your media."
                            )
                        )
                        arrayList11.add(
                            CodeModel(
                                str42,
                                "Enabling test mode for service activity."
                            )
                        )
                        arrayList11.add(
                            CodeModel(
                                "*#*#8255#*#*",
                                "For Google talk Service monitoring."
                            )
                        )
                        arrayList11.add(
                            CodeModel(
                                "*#*#4986*2650468#*#*",
                                "Hardware,Phone,PDA,RF Call date firmware info."
                            )
                        )
                        arrayList11.add(CodeModel(str45, "PDA and Phone firmware information."))
                        arrayList11.add(CodeModel(str44, "FTA Software version."))
                        arrayList11.add(CodeModel(str43, "FTA Hardware version."))
                        arrayList11.add(
                            CodeModel(
                                "*#*#44336#*#*",
                                "Displays Build time and change list number."
                            )
                        )
                        arrayList11.add(CodeModel("*#*#8351#*#*", "Enable voice logging mode."))
                        arrayList11.add(CodeModel("*#*#8350#*#*", "Disable voice logging mode."))
                        arrayList11.add(CodeModel("*#*#7262626#*#*", "Field Test."))
                        arrayList11.add(
                            CodeModel(
                                "*#*#232337#*#*",
                                "Display Bluetooth device address."
                            )
                        )
                        binding.lvCodeList.adapter = CodeListAdapter(arrayList11, this)
                    }

                    val str57 = str55
                    val str58 = str52
                    val str59 = str48
                    val str60 = "*#*#4636#*#*"
                    val str61 = str49
                    val str62 = str21
                    val str63 = str25
                    val str64 = str27
                    val str65 = str42
                    val str66 = str43
                    val str67 = str45
                    val str68 = "*#*#426#*#*"
                    val str69 = str44
                    val str70 = str2
                    val str71 = str51
                    val str72 = str70

                    if (intExtra == "MICROSOFT/WINDOW") {
                        binding.tvToolbar.text = "MICROSOFT/WINDOW"
                        val arrayList12 = ArrayList<CodeModel>()
                        arrayList12.add(CodeModel("*#06#", "Display IMEI number."))
                        arrayList12.add(CodeModel("*#7780#", "Reset to factory setting."))
                        arrayList12.add(CodeModel("*#2820#", "Bluetooth device address."))
                        arrayList12.add(
                            CodeModel(
                                "*#3370#",
                                "Phone automatically restart and increase battery level."
                            )
                        )
                        arrayList12.add(CodeModel("*#4720#", "Half rate Codec Activation."))
                        arrayList12.add(CodeModel("*#4720#", "Half rate Codec deactivation."))
                        arrayList12.add(
                            CodeModel(
                                "*#62209526#",
                                "Display the MAC Address of WLAN adapter."
                            )
                        )
                        arrayList12.add(
                            CodeModel(
                                "#pw+1234567890+1#",
                                "Shows if Sim have restrictions."
                            )
                        )
                        arrayList12.add(
                            CodeModel(
                                "*#3370#",
                                "Increase Signal Strength,better signal reception."
                            )
                        )
                        binding.lvCodeList.adapter = CodeListAdapter(arrayList12, this)
                    }
                    else if (intExtra == "Huawei") {
                        binding.tvToolbar.text = "Huawei"
                        val arrayList13 = ArrayList<CodeModel>()
                        arrayList13.add(CodeModel("*#2820#", "Bluetooth device address."))
                        arrayList13.add(
                            CodeModel(
                                "*#67705646#",
                                "This will clear the LCD Display."
                            )
                        )
                        arrayList13.add(CodeModel("*#0000#", "To View Software version."))
                        arrayList13.add(CodeModel("*#746025625#", "Sim Clock allowed status."))
                        arrayList13.add(CodeModel("*#06#", "Display IMEI number."))
                        arrayList13.add(
                            CodeModel(
                                "*#*#4636#",
                                "Phone Information,Usage and Battery."
                            )
                        )
                        arrayList13.add(CodeModel(str47, "Enter Service menu."))
                        arrayList13.add(CodeModel(str72, "Vibration Test."))
                        arrayList13.add(CodeModel(str69, "FTA Software version."))
                        arrayList13.add(CodeModel(str41, "USB Logging Control."))
                        arrayList13.add(CodeModel("*#9900#", "System Dump mode."))
                        arrayList13.add(CodeModel(str65, "Enable test mode for Service."))
                        arrayList13.add(CodeModel(str72, "Back-light Test."))
                        arrayList13.add(CodeModel("*#*#2664#*#*", "Test the touch Screen."))
                        arrayList13.add(CodeModel("*#301279#", "HSDPA Control menu."))
                        arrayList13.add(CodeModel("*#*#2664#*#*", "Touch Screen test."))
                        arrayList13.add(
                            CodeModel(
                                "*#12580*369#",
                                "Complete S/W and H/W information."
                            )
                        )
                        arrayList13.add(CodeModel("*#9090#", "Diagnostic Configuration."))
                        arrayList13.add(
                            CodeModel(
                                "*#*#273282*255*663282*#*#*",
                                "Backup All media files."
                            )
                        )
                        arrayList13.add(CodeModel(str20, "Wireless LAN test."))
                        arrayList13.add(
                            CodeModel(
                                "*#12580*369#",
                                "Complete S/W and H/W information."
                            )
                        )
                        arrayList13.add(CodeModel("*#9090#", "Diagnostic Configuration."))
                        arrayList13.add(CodeModel(str36, "View Phone Lock Status."))
                        arrayList13.add(CodeModel("*#*#232338#*#*", "Show WiFi MAC Address."))
                        arrayList13.add(CodeModel(str64, "GPS Test Mode."))
                        arrayList13.add(CodeModel("*#*#1575#*#*", "GPS Test."))
                        arrayList13.add(CodeModel(str63, "Bluetooth test."))
                        arrayList13.add(CodeModel(str62, "Detailed Camera information."))
                        binding.lvCodeList.adapter = CodeListAdapter(arrayList13, this)
                    } else {
                        val str73 = "*#*#2664#*#*"
                        val str74 = str41
                        val str75 = "*#67#"
                        val str76 = "*#61#"
                        val str77 = str72
                        val str78 = "*#*#0588#*#*"
                        val str79 = str69
                        val str80 = str64

                        if (intExtra == "INFINIX") {
                            binding.tvToolbar.text = "INFINIX"
                            val arrayList14 = ArrayList<CodeModel>()
                            arrayList14.add(CodeModel("*#06#", "Display IMEI number."))
                            val str81 = str60
                            arrayList14.add(CodeModel(str81, "Phone information of Infinix Hot 4"))
                            arrayList14.add(
                                CodeModel(
                                    str81,
                                    " Battery information of Infinix Hot 4"
                                )
                            )
                            arrayList14.add(CodeModel(str81, "Battery history of Infinix Hot 4"))
                            arrayList14.add(CodeModel(str81, "Usage statistics of Infinix Hot 4"))
                            arrayList14.add(
                                CodeModel(
                                    str59,
                                    "Remove Downloaded apps for Infinix Hot 4"
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    str61,
                                    "Used for factory format for Infinix Hot 4."
                                )
                            )
                            arrayList14.add(CodeModel(str58, "Events calendar."))
                            arrayList14.add(CodeModel(str68, "Debug info for Google Play service."))
                            arrayList14.add(
                                CodeModel(
                                    "*#*#759#*#* ",
                                    "Access Google Partner setup."
                                )
                            )
                            arrayList14.add(CodeModel(str74, "USB logging control ."))
                            arrayList14.add(CodeModel("*#9900#", "System dump mode Infinix Hot 4"))
                            arrayList14.add(
                                CodeModel(
                                    "*#*#97#*#*",
                                    "Language settings in Infinix Hot 4"
                                )
                            )
                            arrayList14.add(CodeModel("*#*#46*#*#", "Reset Sim in Infinix Hot 4"))
                            arrayList14.add(CodeModel(str65, "Used to enter into Service mode."))
                            arrayList14.add(CodeModel(str36, "View phone lock status"))
                            val str82 = str57
                            arrayList14.add(CodeModel(str82, "Ram version"))
                            arrayList14.add(CodeModel(str63, "For Bluetooth testing"))
                            arrayList14.add(CodeModel("*#*#7262626#*#*", "Field testing"))
                            arrayList14.add(
                                CodeModel(
                                    "*#*#232337#*#",
                                    "Display bluetooth device address"
                                )
                            )
                            arrayList14.add(CodeModel("##778 (+call)", "For Epst menu"))
                            arrayList14.add(CodeModel(str62, "Check Camera info in Infinix X551"))
                            arrayList14.add(
                                CodeModel(
                                    "*#*#273283*255*663282*#*#*",
                                    "Backup media files in Infinix X551"
                                )
                            )
                            arrayList14.add(CodeModel(str65, "To check for service activity"))
                            arrayList14.add(
                                CodeModel(
                                    "*#*#232339#*#* OR *#*#526#*#*",
                                    "Wireless Lan Tests"
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    "*#*#232338#*#*",
                                    "To find Mac-address of Wi-Fi"
                                )
                            )
                            arrayList14.add(CodeModel("*#*#0*#*#*", "LCD display checking"))
                            arrayList14.add(
                                CodeModel(
                                    "*#*#0673#*#* OR *#*#0289#*#*",
                                    "For Audio testing"
                                )
                            )
                            arrayList14.add(CodeModel("*7465625*638*Code#", "Enables Network lock"))
                            arrayList14.add(CodeModel(str71, "Disables Network lock"))
                            arrayList14.add(CodeModel("*7465625*782*Code#", "Enables Subset lock "))
                            arrayList14.add(
                                CodeModel(
                                    "#7465625*782*Code#",
                                    "Disables Subset lock "
                                )
                            )
                            arrayList14.add(CodeModel("*7465625*77*Code#", "Enables SP lock"))
                            arrayList14.add(CodeModel("*7465625*77*Code#", "Disables SP lock "))
                            val str83 = str56
                            arrayList14.add(CodeModel(str83, "Enables CP lock "))
                            arrayList14.add(CodeModel(str83, str54))
                            arrayList14.add(CodeModel("*7465625*746*Code#", "Enables SIM lock "))
                            arrayList14.add(CodeModel("*7465625*746*Code#", "Disables SIM lock "))
                            val str84 = str53
                            arrayList14.add(CodeModel(str84, " Activa lock ON"))
                            arrayList14.add(CodeModel(str84, " Activa lock OFF"))
                            arrayList14.add(CodeModel("*7465625*28638#", "Auto Network lock ON"))
                            arrayList14.add(CodeModel("*7465625*28638#", "Auto Network lock OFF"))
                            arrayList14.add(CodeModel("*7465625*28782#", "Auto subset lock ON"))
                            arrayList14.add(CodeModel("*7465625*28782#", "Auto subset lock OFF"))
                            arrayList14.add(CodeModel("*7465625*2877#", "Auto SP lock ON"))
                            arrayList14.add(CodeModel("*7465625*2877#", "Auto SP lock OFF"))
                            arrayList14.add(CodeModel("*7465625*2827#", "Auto CP lock ON"))
                            arrayList14.add(CodeModel("*7465625*2827#", "Auto CP lock OFF"))
                            arrayList14.add(CodeModel("*7465625*28746#", "Auto SIM lock ON"))
                            arrayList14.add(CodeModel("*7465625*28746#", "Auto SIM lock OFF"))
                            arrayList14.add(CodeModel(str20, "WLAN test"))
                            arrayList14.add(CodeModel("*#*#232338#*#*", "Shows WiFi MAC address"))
                            arrayList14.add(CodeModel(str80, "GPS Test"))
                            arrayList14.add(
                                CodeModel(
                                    "*#*#1575#*#*",
                                    "For a more advanced GPS test."
                                )
                            )
                            arrayList14.add(CodeModel(str63, "Bluetooth test."))
                            arrayList14.add(
                                CodeModel(
                                    "*#*#36245#*#*",
                                    "Access email debug information."
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    "*#*#4986*2650468#*#*",
                                    "PDA, Phone, H/W, RFCallDate"
                                )
                            )
                            arrayList14.add(CodeModel(str67, "PDA and Phone firmware information"))
                            arrayList14.add(
                                CodeModel(
                                    "*#1234#",
                                    "PDA and Phone firmware information"
                                )
                            )
                            arrayList14.add(CodeModel(str79, "FTA SW Version."))
                            arrayList14.add(
                                CodeModel(
                                    "*#12580*369#",
                                    "Software and hardware info."
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    "#9090#",
                                    "Diagnostic configuration in Infinix Hot 2."
                                )
                            )
                            arrayList14.add(CodeModel(str66, "FTA HW Version."))
                            arrayList14.add(
                                CodeModel(
                                    "*#*#44336#*#*",
                                    "PDA, Phone, CS, Build Time number."
                                )
                            )
                            arrayList14.add(CodeModel("*#*#0283#*#*", "Packet Loopback."))
                            arrayList14.add(CodeModel("*#*#0*#*#*", "LCD display test."))
                            arrayList14.add(CodeModel("*#*#0673#*#*", "Melody test."))
                            arrayList14.add(CodeModel(" OR *#*#0289#*#*", ""))
                            arrayList14.add(CodeModel(str77, "Device test."))
                            arrayList14.add(
                                CodeModel(
                                    "*#*#2663#*#*",
                                    "Touch screen version Infinix Hot 2"
                                )
                            )
                            val str85 = str73
                            arrayList14.add(CodeModel(str85, "Touch screen test"))
                            arrayList14.add(CodeModel(str78, "Proximity sensor test "))
                            arrayList14.add(CodeModel(str82, "RAM version Infinix Hot 2 "))
                            arrayList14.add(CodeModel("##002#", "Cancel all diverts"))
                            arrayList14.add(
                                CodeModel(
                                    "##004#",
                                    "Cancel all conditional call forwarding"
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    "**004* phone number#",
                                    "Activate all call forwarding"
                                )
                            )
                            arrayList14.add(CodeModel("###21", "Deactivate call forwarding"))
                            arrayList14.add(
                                CodeModel(
                                    "#21#",
                                    "Deactivate Unconditional call forwarding"
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    "*21#",
                                    "Activate Unconditional call forwarding"
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    "*#21#",
                                    "Check the condition call forwarding"
                                )
                            )
                            arrayList14.add(CodeModel("###61", "Switch off & deactivate no answer"))
                            arrayList14.add(CodeModel("#61#", "Deactivate no answer"))
                            arrayList14.add(
                                CodeModel(
                                    "**61* phone number#",
                                    "Enable and Activate no answer"
                                )
                            )
                            arrayList14.add(CodeModel("*61#", "Activate no answer"))
                            arrayList14.add(CodeModel(str76, "Check the condition no answer"))
                            arrayList14.add(
                                CodeModel(
                                    "*62#",
                                    "Activate Diversion in case of not available"
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    "*#62#",
                                    "Check condition in case of not available"
                                )
                            )
                            arrayList14.add(CodeModel("###62", "Switch off and deactivate"))
                            arrayList14.add(CodeModel("#62#", "Deactivate"))
                            arrayList14.add(CodeModel("**62*phone number#", "Enable and Activate"))
                            arrayList14.add(CodeModel("*62#", "Activate"))
                            arrayList14.add(CodeModel("*#62#", "Check the condition "))
                            arrayList14.add(
                                CodeModel(
                                    "###67",
                                    "Switch off Diversion in case of busy"
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    "#67#",
                                    "Deactivate Diversion in case of busy"
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    "**67*phone number#",
                                    "Enable and Activate Diversion if busy"
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    str75,
                                    "Check condition Diversion in case of busy"
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    "**330*password#",
                                    "Activate Barring of all calls"
                                )
                            )
                            arrayList14.add(
                                CodeModel(
                                    "#330*password#",
                                    "Deactivate Barring of all calls"
                                )
                            )
                            arrayList14.add(CodeModel("*#330#", "Check the condition"))
                            arrayList14.add(CodeModel("*111#", "GP Smart menu"))
                            arrayList14.add(CodeModel("*140#", "Rob Smart menu"))
                            arrayList14.add(CodeModel("*789#", "Banglalink Smart menu"))
                            arrayList14.add(CodeModel(str85, "Check touch-screen in Infinix X557"))
                            binding.lvCodeList.adapter = CodeListAdapter(arrayList14, this)
                            return
                        }

                        val str86 = str61
                        val str87 = str59
                        val str88 = str57
                        val str89 = str73
                        val str90 = str77
                        val str91 = str78
                        val str92 = str80
                        val str93 = str79
                        val str94 = str66
                        val str95 = str67
                        val str96 = "Enables SIM lock"
                        val str97 = str58
                        val str98 = str53
                        val str99 = "*#*#232338#*#*"
                        val str100 = str56
                        val str101 = str60
                        val str102 = str63
                        val str103 = str54
                        val str104 = str20
                        val str105 = str68
                        val str106 = str65
                        val str107 = str71
                        val str108 = "*#*#0*#*#*"
                        val str109 = str97
                        val str110 = str103

                        if (intExtra == "Vivo") {
                            binding.tvToolbar.text = "Vivo"
                            val arrayList15 = ArrayList<CodeModel>()
                            arrayList15.add(CodeModel("*#06#", "Display IMEI number."))
                            arrayList15.add(
                                CodeModel(
                                    "*#*#273282*255*663282*#*#*",
                                    "Immediate backup of all media files"
                                )
                            )
                            arrayList15.add(CodeModel("*#*#4636#*#* ", "Phone information "))
                            arrayList15.add(CodeModel("*#*#4636#*#* ", "Battery information "))
                            arrayList15.add(CodeModel("*#*#4636#*#* ", "Battery history "))
                            arrayList15.add(CodeModel(str36, "View phone lock status "))
                            arrayList15.add(CodeModel("*7465625*638*Code#", "Enables Network lock"))
                            arrayList15.add(CodeModel("#7465625*782*Code#", "Disables Subset lock"))
                            arrayList15.add(CodeModel("*7465625*77*Code#", "Enables SP lock "))
                            arrayList15.add(
                                CodeModel(
                                    "*#*#7780#*#* ",
                                    "System and application data and settings "
                                )
                            )
                            arrayList15.add(CodeModel("*#9900#", "System dump mode Vivo Y51L"))
                            arrayList15.add(
                                CodeModel(
                                    "*#*#97#*#*",
                                    "Language and Keyboard settings in Vivo Y51L"
                                )
                            )
                            arrayList15.add(CodeModel("*#*#46*#*#", "Reset Sim in Vivo Y51L"))
                            arrayList15.add(CodeModel("*#301279#", "HSDPA, Control Menu "))
                            arrayList15.add(
                                CodeModel(
                                    str86,
                                    "This code is used for factory format."
                                )
                            )
                            arrayList15.add(CodeModel(str62, "Get information about phone camera"))
                            arrayList15.add(CodeModel("*#*#7594#*#*", "End Call / Power"))
                            arrayList15.add(CodeModel(str107, "Disables Network lock"))
                            arrayList15.add(CodeModel("*7465625*782*Code#", str50))
                            arrayList15.add(CodeModel(str109, "Events calendar."))
                            arrayList15.add(
                                CodeModel(
                                    str105,
                                    "Debug information for Google Play service."
                                )
                            )
                            arrayList15.add(
                                CodeModel(
                                    "*#*#759#*#*",
                                    "Access Google Partner setup "
                                )
                            )
                            arrayList15.add(CodeModel(str74, "USB logging control "))
                            arrayList15.add(CodeModel("#7465625*77*Code#", "Disables SP lock"))
                            arrayList15.add(CodeModel(str100, "Enables CP lock"))
                            arrayList15.add(CodeModel("#7465625*27*Code#", str110))
                            arrayList15.add(CodeModel("#7465625*746*Code#", str37))
                            arrayList15.add(CodeModel(str35, str96))
                            arrayList15.add(CodeModel(str98, "Activa lock ON "))
                            arrayList15.add(CodeModel("#7465625*228#", "Activa lock OFF"))
                            binding.lvCodeList.adapter = CodeListAdapter(arrayList15, this)
                        }

                        val str111 = str74
                        val str112 = str35
                        val str113 = str50
                        val str114 = str105
                        val str115 = "*#9900#"
                        val str116 = str37
                        val str117 = str110
                        val str118 = str36
                        val str119 = str98
                        val str120 = str109
                        val str121 = str96
                        val str122 = "*7465625*782*Code#"

                        if (intExtra == "Acer") {
                            binding.tvToolbar.text = "Acer"
                            val arrayList16 = ArrayList<CodeModel>()
                            arrayList16.add(CodeModel("*#06#", "Display IMEI number."))
                            arrayList16.add(CodeModel("*#400#", "Display Adc/ Set Cal-Value."))
                            arrayList16.add(CodeModel("*#402#", "Set LCD Contrast."))
                            arrayList16.add(CodeModel("*#403#", "Display Errors Info."))
                            arrayList16.add(CodeModel("*#300#", "Display Info Hw & Sw."))
                            arrayList16.add(CodeModel("*#301#", "Menu Test."))
                            arrayList16.add(CodeModel("*#302#", "Menu Acoustics."))
                            arrayList16.add(
                                CodeModel(
                                    "*#303#",
                                    "Settings saved, Set English language?."
                                )
                            )
                            arrayList16.add(CodeModel("*#307#", "Menu Engineering."))
                            arrayList16.add(CodeModel("*#311#", "Reset Phone Code."))
                            arrayList16.add(CodeModel("*#330#", "Execute not success."))
                            arrayList16.add(CodeModel("*#331#", "Service deactivated."))
                            arrayList16.add(CodeModel("*#332#", "Service unavailable."))
                            arrayList16.add(CodeModel("*#333#", "Execute not success."))
                            arrayList16.add(CodeModel("*#351#", "Service unavailable."))
                            arrayList16.add(CodeModel("*#2558#", "Time of network connection."))
                            arrayList16.add(CodeModel("*#2562#", "Fores reconnection to network."))
                            arrayList16.add(
                                CodeModel(
                                    "*#7489#",
                                    "Dispalys and modify phones' security code."
                                )
                            )
                            arrayList16.add(CodeModel("*#3377#", "SIM lock information."))
                            arrayList16.add(CodeModel("*#7378#", "SIM card Informations."))
                            arrayList16.add(CodeModel("*#7693#", "Enable/disable Sleep Mode."))
                            arrayList16.add(
                                CodeModel(
                                    str86,
                                    "This code is used for factory format."
                                )
                            )
                            arrayList16.add(CodeModel(str62, "Get information about phone camera"))
                            arrayList16.add(CodeModel("*#*#7594#*#*", "End Call / Power"))
                            arrayList16.add(CodeModel("#7465625*77*Code#", "Disables SP lock"))
                            arrayList16.add(CodeModel(str100, "Enables CP lock"))
                            arrayList16.add(CodeModel("#7465625*27*Code#", str117))
                            arrayList16.add(CodeModel("#7465625*746*Code#", str116))
                            arrayList16.add(CodeModel(str112, str121))
                            arrayList16.add(CodeModel(str119, "Activa lock ON "))
                            arrayList16.add(CodeModel("#7465625*228#", "Activa lock OFF"))
                            binding.lvCodeList.adapter = CodeListAdapter(arrayList16, this)
                        }
                        else if (intExtra == "Xiaomi") {
                            binding.tvToolbar.text = "Xiaomi"
                            val arrayList17 = ArrayList<CodeModel>()
                            arrayList17.add(CodeModel("*#06#", "Display IMEI number."))
                            arrayList17.add(CodeModel("*#*#6484#*#*", "Engineering Mode-1."))
                            arrayList17.add(CodeModel("*#*#64663#*#*", "Engineering Mode-2."))
                            arrayList17.add(CodeModel("**#*#4636#*#*", "Phone Info Mode."))
                            arrayList17.add(CodeModel("*#*#564548#*#*", "View Version Info."))
                            arrayList17.add(CodeModel("*#*#284#*#*", "Send bug report ."))
                            arrayList17.add(CodeModel(str101, "Phone Info Menu in Redmi Note 3."))
                            arrayList17.add(CodeModel(str107, "Disables Network lock"))
                            arrayList17.add(CodeModel(str122, str113))
                            arrayList17.add(CodeModel(str120, "Events calendar."))
                            arrayList17.add(CodeModel(str114, "Debug information for Google Play service."))
                            arrayList17.add(CodeModel("*#*#759#*#*", "Access Google Partner setup "))
                            arrayList17.add(CodeModel(str111, "USB logging control "))
                            arrayList17.add(CodeModel(str86, "This code is used for factory format."))
                            arrayList17.add(CodeModel(str62, "Get information about phone camera"))
                            arrayList17.add(CodeModel("*#*#7594#*#*", "End Call / Power"))
                            arrayList17.add(CodeModel("#7465625*77*Code#", "Disables SP lock"))
                            arrayList17.add(CodeModel(str100, "Enables CP lock"))
                            arrayList17.add(CodeModel("#7465625*27*Code#", str117))
                            arrayList17.add(CodeModel("#7465625*746*Code#", str116))
                            arrayList17.add(CodeModel(str112, str121))
                            arrayList17.add(CodeModel(str119, "Activa lock ON "))
                            arrayList17.add(CodeModel("#7465625*228#", "Activa lock OFF"))
                            binding.lvCodeList.adapter = CodeListAdapter(arrayList17, this)
                        } else {
                            val str123 = str101
                            val str124 = str120
                            val str125 = str119
                            val str126 = str62
                            val str127 = str122
                            val str128 = str111
                            val str129 = str86
                            val str130 = str114
                            val str131 = str121
                            if (intExtra == "NOKIA") {
                                binding.tvToolbar.text = "NOKIA"
                                val arrayList18 = ArrayList<CodeModel>()
                                arrayList18.add(CodeModel("*#06#", "Display IMEI number."))
                                arrayList18.add(CodeModel(str124, "Calendar."))
                                arrayList18.add(
                                    CodeModel(
                                        str130,
                                        "Debug info for Google Play Service  "
                                    )
                                )
                                arrayList18.add(CodeModel("#7465625*77*Code#", "Disables SP lock"))
                                arrayList18.add(CodeModel(str100, "Enables CP lock"))
                                arrayList18.add(CodeModel(str108, "LCD display test "))
                                arrayList18.add(CodeModel("*#*#0673#*#*", "Melody test "))
                                arrayList18.add(CodeModel(str89, "Touch screen test "))
                                arrayList18.add(CodeModel(str91, "Proximity sensor test "))
                                arrayList18.add(CodeModel("*#06#", "Display IMEI number."))
                                arrayList18.add(
                                    CodeModel(
                                        "*#*#759#*#*",
                                        "Access Google Partner Setup"
                                    )
                                )
                                arrayList18.add(CodeModel("*#*#2486#*#*", "Engineering Mode"))
                                arrayList18.add(
                                    CodeModel(
                                        "*3370#",
                                        "Activate Enhanced Full Rate Codec."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "#3370#",
                                        "Deactivate Enhanced Full Rate Codec."
                                    )
                                )
                                arrayList18.add(CodeModel("*#4720#", "Activate Half Rate Codec."))
                                arrayList18.add(CodeModel("*#4720#", "Deactivate Half Rate Codec."))
                                arrayList18.add(
                                    CodeModel(
                                        " *#9999#",
                                        "Phones software version if *#0000# does not work"
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "#pw+1234567890+1#",
                                        "Provider Lock Status."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "#pw+1234567890+2#",
                                        "Network Lock Status"
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "#pw+1234567890+3#",
                                        "Country Lock Status"
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "#pw+1234567890+4#",
                                        "SIM Card Lock Status."
                                    )
                                )
                                arrayList18.add(CodeModel("*#21#", "All Calls are diverted to..."))
                                arrayList18.add(
                                    CodeModel(
                                        "*#43#",
                                        "Call Waiting status of your phone."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        str76,
                                        " On No Reply calls are diverted to."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "*#62#",
                                        " Divert If Unreachable calls,are diverted to."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        " *#67#",
                                        "On Busy Calls are diverted to."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "*#*#273282*255*663282*#*#*",
                                        "Immediate backup of all media files."
                                    )
                                )
                                arrayList18.add(CodeModel("*#*#4636#*#* ", " Phone information "))
                                arrayList18.add(
                                    CodeModel(
                                        "*#*#4636#*#* ",
                                        " Battery information  "
                                    )
                                )
                                arrayList18.add(CodeModel("*#*#4636#*#* ", " Battery history "))
                                arrayList18.add(CodeModel("*#*#4636#*#* ", " Usage statistics "))
                                arrayList18.add(CodeModel(str128, "USB logging control "))
                                arrayList18.add(
                                    CodeModel(
                                        "*#*#46*#*#",
                                        "Reset Sim in Nokia X Dual SIM"
                                    )
                                )
                                arrayList18.add(CodeModel(str118, "View phone lock status "))
                                arrayList18.add(
                                    CodeModel(
                                        "*7465625*638*Code#",
                                        "Enables Network lock"
                                    )
                                )
                                arrayList18.add(CodeModel(str107, "Disables Network lock"))
                                arrayList18.add(CodeModel(str127, str113))
                                arrayList18.add(
                                    CodeModel(
                                        "#7465625*782*Code#",
                                        "Disables Subset lock"
                                    )
                                )
                                arrayList18.add(CodeModel("*7465625*77*Code#", "Enables SP lock "))
                                arrayList18.add(
                                    CodeModel(
                                        "*#67705646#.",
                                        "Removes operator logo on 3310 & 3330"
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "*#73#.",
                                        "Reset phone timers and game scores"
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "*#746025625#",
                                        "Displays the SIM Clock status."
                                    )
                                )
                                arrayList18.add(CodeModel("*#7760#", " Manufactures code."))
                                arrayList18.add(CodeModel("*#7780#", "Restore factory settings."))
                                arrayList18.add(
                                    CodeModel(
                                        "*#8110#",
                                        "Software version for the nokia 8110."
                                    )
                                )
                                arrayList18.add(CodeModel("*#92702689#", " Displays Serial Number"))
                                arrayList18.add(CodeModel("*#92702689#", " Displays Date Made"))
                                arrayList18.add(CodeModel("*#92702689#", " Displays Purchase Date"))
                                arrayList18.add(
                                    CodeModel(
                                        "*#92702689#",
                                        " Displays Date of last repair"
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "*#92702689#",
                                        " Displays Transfer User Data."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "#94870345123456789#",
                                        "Deactivate the PWM-Mem."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "**21*number#",
                                        "Turn on “All Calls” diverting."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        " **61*number#",
                                        " Turn on “No Reply” diverting."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "12345",
                                        " This is the default security code.."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "*#*#*7378423#*#*",
                                        "Service Test, Pressure Sensor."
                                    )
                                )
                                arrayList18.add(
                                    CodeModel(
                                        "*#*#46360#*#*",
                                        "Acess phone Information."
                                    )
                                )
                                arrayList18.add(CodeModel(str104, str33))
                                arrayList18.add(CodeModel("*#*#526#*#*", str33))
                                arrayList18.add(CodeModel("*#*#528#*#*", str33))
                                arrayList18.add(CodeModel("#7465625*27*Code#", str117))
                                arrayList18.add(CodeModel("#7465625*746*Code#", str116))
                                arrayList18.add(CodeModel(str112, str131))
                                arrayList18.add(CodeModel(str125, "Activa lock ON "))
                                arrayList18.add(CodeModel("#7465625*228#", "Activa lock OFF"))
                                binding.lvCodeList.adapter = CodeListAdapter(arrayList18, this)
                            }

                            val str133 = str104
                            val str134 = str131
                            val str135 = str76
                            val str136 = str89
                            val str137 = str91
                            if (intExtra == "Tecno") {
                                binding.tvToolbar.text = "Tecno"
                                val arrayList19 = ArrayList<CodeModel>()
                                arrayList19.add(CodeModel("*#06#", "Display IMEI number."))
                                arrayList19.add(CodeModel("*#07#", "Specific Absorption Rate"))
                                arrayList19.add(
                                    CodeModel(
                                        "*#0228# ",
                                        "Battery status (ADC, RSSI reading) "
                                    )
                                )
                                arrayList19.add(
                                    CodeModel(
                                        str47,
                                        "Test LCD, hardware and many other parts of your Tecno mobile phone"
                                    )
                                )
                                arrayList19.add(CodeModel("*#*#225#*#* ", "Calendar Info "))
                                arrayList19.add(CodeModel(str130, "Google Play Services"))
                                arrayList19.add(
                                    CodeModel(
                                        "*#1234#",
                                        "Check Software Version of Tecno Phone."
                                    )
                                )
                                arrayList19.add(CodeModel("*#*#0289#*#*", "Device Audio test"))
                                arrayList19.add(CodeModel(str136, "Device Touch-Screen test"))
                                arrayList19.add(
                                    CodeModel(
                                        "*#*#232339#*#* ",
                                        "Device Wireless Lan Test "
                                    )
                                )
                                arrayList19.add(CodeModel(str115, "System dump mode Vivo Y51L"))
                                arrayList19.add(
                                    CodeModel(
                                        "*#*#97#*#*",
                                        "Language and Keyboard settings in Vivo Y51L"
                                    )
                                )
                                arrayList19.add(CodeModel("*#*#46*#*#", "Reset Sim in Vivo Y51L"))
                                arrayList19.add(CodeModel("*#301279#", "HSDPA, Control Menu "))
                                arrayList19.add(
                                    CodeModel(
                                        str129,
                                        "This code is used for factory format."
                                    )
                                )
                                arrayList19.add(
                                    CodeModel(
                                        str126,
                                        "Get information about phone camera"
                                    )
                                )
                                arrayList19.add(CodeModel("*#*#7594#*#*", "End Call / Power"))
                                arrayList19.add(CodeModel(str107, "Disables Network lock"))
                                arrayList19.add(CodeModel(str127, str113))
                                arrayList19.add(CodeModel(str124, "Events calendar."))
                                arrayList19.add(
                                    CodeModel(
                                        str130,
                                        "Debug information for Google Play service."
                                    )
                                )
                                arrayList19.add(
                                    CodeModel(
                                        "*#*#759#*#*",
                                        "Access Google Partner setup "
                                    )
                                )
                                arrayList19.add(CodeModel(str128, "USB logging control "))
                                arrayList19.add(CodeModel(str99, "Displays Wi-Fi Mac-address"))
                                arrayList19.add(CodeModel(str93, "FTA Software version"))
                                arrayList19.add(CodeModel(str94, "FTA Hardware version "))
                                arrayList19.add(CodeModel("#7465625*746*Code#", str116))
                                arrayList19.add(CodeModel(str112, str134))
                                arrayList19.add(CodeModel(str95, "Device firmware info"))
                                arrayList19.add(
                                    CodeModel(
                                        "*#*#44336#*#*",
                                        "Displays Build time & change list number"
                                    )
                                )
                                binding.lvCodeList.adapter = CodeListAdapter(arrayList19, this)
                                return
                            }

                            val str138 = str99
                            val str139 = str47
                            val str140 = str115
                            val str141 = str126
                            val str142 = str129
                            val str143 = str93
                            val str144 = str95
                            val str145 = str134
                            val str146 = str112
                            val str147 = str94
                            if (intExtra == "Asus") {
                                binding.tvToolbar.text = "Asus"
                                val arrayList20 = ArrayList<CodeModel>()
                                arrayList20.add(CodeModel("*#06#", "Display IMEI number."))
                                val str148 = str123
                                arrayList20.add(
                                    CodeModel(
                                        str148,
                                        "Display information about Android Phone, Battery and Usage statistics"
                                    )
                                )
                                arrayList20.add(
                                    CodeModel(
                                        str136,
                                        "Android Device Touch-Screen test "
                                    )
                                )
                                arrayList20.add(
                                    CodeModel(
                                        str87,
                                        "Reset Android device. Erase all your device data like photos, apps, and settings, etc."
                                    )
                                )
                                arrayList20.add(CodeModel("*#*#225#*#* ", "Calendar Info "))
                                arrayList20.add(CodeModel(str88, "Android Device Ram version"))
                                arrayList20.add(CodeModel(str138, "Displays Wi-Fi Mac-address"))
                                arrayList20.add(CodeModel(str148, "Display information"))
                                arrayList20.add(CodeModel("*#*#64663#*#*", "QC Test"))
                                arrayList20.add(
                                    CodeModel(
                                        "*#*#232339#*#* ",
                                        "FTA hardware version"
                                    )
                                )
                                arrayList20.add(CodeModel(str147, "FTA hardware version"))
                                arrayList20.add(
                                    CodeModel(
                                        "*#*#97#*#*",
                                        "Language and Keyboard settings in Vivo Y51L"
                                    )
                                )
                                arrayList20.add(CodeModel("*#*#46*#*#", "Reset Sim in Vivo Y51L"))
                                arrayList20.add(CodeModel("*#301279#", "HSDPA, Control Menu "))
                                arrayList20.add(CodeModel(str92, "Quick GPS Test"))
                                arrayList20.add(
                                    CodeModel(
                                        str136,
                                        "Android Device Touch-Screen test"
                                    )
                                )
                                arrayList20.add(CodeModel(str108, "Android Device LCD test"))
                                arrayList20.add(CodeModel(str137, "Proximity sensor test"))
                                arrayList20.add(CodeModel(str127, str113))
                                arrayList20.add(CodeModel(str124, "Events calendar."))
                                arrayList20.add(
                                    CodeModel(
                                        str130,
                                        "Debug information for Google Play service."
                                    )
                                )
                                arrayList20.add(CodeModel(str133, "Device Bluetooth test"))
                                arrayList20.add(CodeModel(str128, "USB logging control "))
                                arrayList20.add(CodeModel(str138, "Displays Wi-Fi Mac-address"))
                                arrayList20.add(CodeModel(str143, "FTA Software version"))
                                arrayList20.add(CodeModel(str147, "FTA Hardware version "))
                                arrayList20.add(CodeModel("#7465625*746*Code#", str116))
                                arrayList20.add(CodeModel(str146, str145))
                                arrayList20.add(CodeModel(str144, "Device firmware info"))
                                arrayList20.add(CodeModel(str102, "Packet Loopback test"))
                                binding.lvCodeList.adapter = CodeListAdapter(arrayList20, this)
                                return
                            }

                            val str149 = str116
                            val str150 = "Display IMEI number."
                            val str151 = "*#06#"
                            val str152 = str128
                            val str153 = str108
                            val str154 = str146
                            val str155 = str145
                            val str156 = str102
                            val str157 = str87
                            val str158 = str88
                            val str159 = str123
                            val str160 = str133
                            val str161 = str144
                            val str162 = str143
                            val str163 = "#7465625*746*Code#"
                            val str164 = str92
                            val str165 = str137
                            if (intExtra == "Honor") {
                                binding.tvToolbar.text = "Honor"
                                val arrayList21 = ArrayList<CodeModel>()
                                arrayList21.add(
                                    CodeModel(
                                        str136,
                                        "Android Device Touch-Screen test"
                                    )
                                )
                                arrayList21.add(CodeModel("*#*#0289#*#*", "Device Audio test"))
                                arrayList21.add(
                                    CodeModel(
                                        str159,
                                        "Display information about Android Phone, Battery and Usage statistics "
                                    )
                                )
                                arrayList21.add(CodeModel(str158, " Android Device Ram version"))
                                arrayList21.add(CodeModel("*#06# ", "Displays IMEI number"))
                                arrayList21.add(CodeModel(str138, "Displays Wi-Fi Mac-address"))
                                arrayList21.add(
                                    CodeModel(
                                        str157,
                                        " Reset Android device. Erase all your device data like photos, apps, and settings, etc."
                                    )
                                )
                                arrayList21.add(
                                    CodeModel(
                                        "*#000000#",
                                        " Use this code to enter your Honor’s Service Menu"
                                    )
                                )
                                arrayList21.add(
                                    CodeModel(
                                        "*#*#64663#*#*",
                                        " Using following code, will master reset your Honor device when your sim card is inserted."
                                    )
                                )
                                arrayList21.add(CodeModel("###337*07#", "FTA hardware version"))
                                arrayList21.add(CodeModel(str147, "FTA hardware version"))
                                arrayList21.add(CodeModel("*#301279#", "HSDPA, Control Menu "))
                                arrayList21.add(CodeModel(str164, "Quick GPS Test"))
                                arrayList21.add(
                                    CodeModel(
                                        str136,
                                        "Android Device Touch-Screen test"
                                    )
                                )
                                arrayList21.add(CodeModel(str153, "Android Device LCD test"))
                                arrayList21.add(CodeModel(str165, "Proximity sensor test"))
                                arrayList21.add(CodeModel(str127, str113))
                                arrayList21.add(CodeModel(str124, "Events calendar."))
                                arrayList21.add(
                                    CodeModel(
                                        str130,
                                        "Debug information for Google Play service."
                                    )
                                )
                                arrayList21.add(CodeModel(str160, "Device Bluetooth test"))
                                arrayList21.add(CodeModel(str152, "USB logging control "))
                                arrayList21.add(CodeModel(str138, "Displays Wi-Fi Mac-address"))
                                arrayList21.add(CodeModel(str162, "FTA Software version"))
                                arrayList21.add(CodeModel(str147, "FTA Hardware version "))
                                arrayList21.add(CodeModel(str163, str149))
                                arrayList21.add(CodeModel(str154, str155))
                                arrayList21.add(CodeModel(str161, "Device firmware info"))
                                arrayList21.add(CodeModel(str156, "Packet Loopback test"))
                                binding.lvCodeList.adapter = CodeListAdapter(arrayList21, this)
                                return
                            }
                            val str166 = str160
                            val str167 = str162
                            val str168 = str161
                            val str169 = str156
                            if (intExtra == "iPhone") {
                                binding.tvToolbar.text = "iPhone"
                                val arrayList22 = ArrayList<CodeModel>()
                                arrayList22.add(CodeModel("*3001#12345#*", "Field test mode."))
                                arrayList22.add(CodeModel("*#5005*7672#", "SMS center number."))
                                arrayList22.add(CodeModel("*3370#", "Turn off or on EFR."))
                                arrayList22.add(CodeModel(str151, str150))
                                arrayList22.add(
                                    CodeModel(
                                        "*#31#",
                                        "Hide your number on call option."
                                    )
                                )
                                arrayList22.add(
                                    CodeModel(
                                        "*#225#",
                                        "Find out your current mobile account balance."
                                    )
                                )
                                arrayList22.add(
                                    CodeModel(
                                        "*#777#",
                                        "Find out prepaid mobile account balance."
                                    )
                                )
                                arrayList22.add(CodeModel(str135, "Number of missed calls."))
                                arrayList22.add(CodeModel("*#21#", "Call forwarding status."))
                                arrayList22.add(CodeModel(str75, "Call forwarding number."))
                                arrayList22.add(
                                    CodeModel(
                                        "*#33#",
                                        "Find out what mobile services are disabled on your phone."
                                    )
                                )
                                binding.lvCodeList.adapter = CodeListAdapter(arrayList22, this)
                                return
                            }

                            val str170 = str150
                            val str171 = str167
                            val str172 = str147
                            val str173 = str168
                            val str174 = str151
                            val str175 = str135
                            val str176 = str157
                            val str177 = str75
                            val str178 = str138
                            if (intExtra == "Realme") {
                                binding.tvToolbar.text = "Realme"
                                val arrayList23 = ArrayList<CodeModel>()
                                arrayList23.add(CodeModel(str174, str170))
                                arrayList23.add(
                                    CodeModel(
                                        "*#31#",
                                        "Hide your number on call option."
                                    )
                                )
                                arrayList23.add(
                                    CodeModel(
                                        "*#225#",
                                        "Find out your current mobile account balance."
                                    )
                                )
                                arrayList23.add(
                                    CodeModel(
                                        "*#777#",
                                        "Find out prepaid mobile account balance."
                                    )
                                )
                                arrayList23.add(CodeModel(str175, "Number of missed calls."))
                                arrayList23.add(CodeModel("*#21#", "Call forwarding status."))
                                arrayList23.add(CodeModel(str177, "Call forwarding number."))
                                arrayList23.add(
                                    CodeModel(
                                        "*#33#",
                                        "Find out what mobile services are disabled on your phone."
                                    )
                                )
                                arrayList23.add(
                                    CodeModel(
                                        "*#43#",
                                        "Check if call waiting is on or off."
                                    )
                                )
                                arrayList23.add(CodeModel("*#43#", "Turn on call waiting."))
                                arrayList23.add(CodeModel("*#43#", "Turn off call waiting."))
                                arrayList23.add(
                                    CodeModel(
                                        "*#646#",
                                        "Check minutes left on contract."
                                    )
                                )
                                arrayList23.add(CodeModel("*3001#12345#*", "Field test mode."))
                                arrayList23.add(CodeModel("*#5005*7672#", "SMS center number."))
                                arrayList23.add(CodeModel("*3370#", "Turn off or on EFR."))
                                arrayList23.add(
                                    CodeModel(
                                        "*#43#",
                                        "Check if call waiting is on or off."
                                    )
                                )
                                arrayList23.add(CodeModel("*#43#", "Turn on call waiting."))
                                arrayList23.add(CodeModel("*#43#", "Turn off call waiting."))
                                arrayList23.add(
                                    CodeModel(
                                        "*#646#",
                                        "Check minutes left on contract."
                                    )
                                )
                                binding.lvCodeList.adapter = CodeListAdapter(arrayList23, this)
                            }
                            else if (intExtra == "Zte") {
                                binding.tvToolbar.text = "ZTE"
                                val arrayList24 = ArrayList<CodeModel>()
                                arrayList24.add(CodeModel(str136, "Android Device Touch-Screen test"))
                                arrayList24.add(CodeModel("*#*#0289#*#*", "Device Audio test"))
                                arrayList24.add(CodeModel("*#21#", "Call forwarding status."))
                                arrayList24.add(CodeModel(str177, "Call forwarding number."))
                                arrayList24.add(CodeModel("*#33#", "Find out what mobile services are disabled on your phone."))
                                arrayList24.add(CodeModel("*#43#", "Check if call waiting is on or off."))
                                arrayList24.add(CodeModel("*#43#", "Turn on call waiting."))
                                arrayList24.add(CodeModel("*#43#", "Turn off call waiting."))
                                arrayList24.add(CodeModel(str159, "Display information about Android Phone, Battery and Usage statistics "))
                                arrayList24.add(CodeModel(str158, "Android Device Ram version"))
                                arrayList24.add(CodeModel(str174, str170))
                                arrayList24.add(CodeModel("*#31#", "Hide your number on call option."))
                                arrayList24.add(CodeModel("*#225#", "Find out your current mobile account balance."))
                                arrayList24.add(CodeModel("*#777#", "Find out prepaid mobile account balance."))
                                arrayList24.add(CodeModel(str175, "Number of missed calls."))
                                arrayList24.add(CodeModel("*#646#", "Check minutes left on contract."))
                                arrayList24.add(CodeModel("*3001#12345#*", "Field test mode."))
                                arrayList24.add(CodeModel("*#5005*7672#", "SMS center number."))
                                arrayList24.add(CodeModel("*3370#", "Turn off or on EFR."))
                                binding.lvCodeList.adapter = CodeListAdapter(arrayList24, this)
                            }
                            else if (intExtra == "OnePlus") {
                                binding.tvToolbar.text = "One Plus"
                                val arrayList25 = ArrayList<CodeModel>()
                                arrayList25.add(
                                    CodeModel(
                                        "*#7465625*77*#",
                                        "Insert Operator Lock Keycode."
                                    )
                                )
                                arrayList25.add(
                                    CodeModel(
                                        "*7465625*638*#",
                                        "Configure Network Lock MCC/MNC."
                                    )
                                )
                                arrayList25.add(
                                    CodeModel(
                                        "*#7465625*638*#",
                                        "Insert Network Keycode."
                                    )
                                )
                                arrayList25.add(CodeModel("*#0228#", "ADC Reading."))
                                arrayList25.add(
                                    CodeModel(
                                        "*#7465625*27*#",
                                        "Insert Content Provider Keycode."
                                    )
                                )
                                arrayList25.add(
                                    CodeModel(
                                        "*#225#",
                                        "Find out your current mobile account balance."
                                    )
                                )
                                arrayList25.add(
                                    CodeModel(
                                        "*#777#",
                                        "Find out prepaid mobile account balance."
                                    )
                                )
                                arrayList25.add(CodeModel(str175, "Number of missed calls."))
                                arrayList25.add(
                                    CodeModel(
                                        "*#646#",
                                        "Check minutes left on contract."
                                    )
                                )
                                arrayList25.add(CodeModel("*3001#12345#*", "Field test mode."))
                                arrayList25.add(CodeModel("*#5005*7672#", "SMS center number."))
                                arrayList25.add(CodeModel("*3370#", "Turn off or on EFR."))
                                arrayList25.add(
                                    CodeModel(
                                        "*#43#",
                                        "Check if call waiting is on or off."
                                    )
                                )
                                arrayList25.add(
                                    CodeModel(
                                        "*#646#",
                                        "Check minutes left on contract."
                                    )
                                )
                                arrayList25.add(
                                    CodeModel(
                                        str136,
                                        "Android Device Touch-Screen test"
                                    )
                                )
                                arrayList25.add(CodeModel("*#*#0289#*#*", "Device Audio test"))
                                arrayList25.add(CodeModel("*#21#", "Call forwarding status."))
                                arrayList25.add(CodeModel(str177, "Call forwarding number."))
                                arrayList25.add(
                                    CodeModel(
                                        "*#33#",
                                        "Find out what mobile services are disabled on your phone."
                                    )
                                )
                                arrayList25.add(
                                    CodeModel(
                                        "*#43#",
                                        "Check if call waiting is on or off."
                                    )
                                )
                                arrayList25.add(CodeModel("*#43#", "Turn on call waiting."))
                                arrayList25.add(CodeModel("*#43#", "Turn off call waiting."))
                                arrayList25.add(
                                    CodeModel(
                                        str159,
                                        "Display information about Android Phone, Battery and Usage statistics "
                                    )
                                )
                                arrayList25.add(CodeModel(str158, "Android Device Ram version"))
                                arrayList25.add(CodeModel(str174, str170))
                                arrayList25.add(
                                    CodeModel(
                                        "*#31#",
                                        "Hide your number on call option."
                                    )
                                )
                                binding.lvCodeList.adapter = CodeListAdapter(arrayList25, this)
                            }
                            else if (intExtra == "Plam") {
                                binding.tvToolbar.text = "Plam"
                                val arrayList26 = ArrayList<CodeModel>()
                                arrayList26.add(CodeModel(str174, str170))
                                arrayList26.add(
                                    CodeModel(
                                        "*#7465625*77*#",
                                        "Insert Operator Lock Keycode."
                                    )
                                )
                                arrayList26.add(
                                    CodeModel(
                                        "*7465625*638*#",
                                        "Configure Network Lock MCC/MNC."
                                    )
                                )
                                arrayList26.add(
                                    CodeModel(
                                        "*#43#",
                                        "Check if call waiting is on or off."
                                    )
                                )
                                arrayList26.add(
                                    CodeModel(
                                        "*#646#",
                                        "Check minutes left on contract."
                                    )
                                )
                                arrayList26.add(
                                    CodeModel(
                                        str136,
                                        "Android Device Touch-Screen test"
                                    )
                                )
                                arrayList26.add(CodeModel("*#*#0289#*#*", "Device Audio test"))
                                arrayList26.add(CodeModel("*#21#", "Call forwarding status."))
                                arrayList26.add(CodeModel(str177, "Call forwarding number."))
                                arrayList26.add(
                                    CodeModel(
                                        "*#33#",
                                        "Find out what mobile services are disabled on your phone."
                                    )
                                )
                                arrayList26.add(
                                    CodeModel(
                                        "*#43#",
                                        "Check if call waiting is on or off."
                                    )
                                )
                                arrayList26.add(CodeModel("*#43#", "Turn on call waiting."))
                                arrayList26.add(CodeModel("*#43#", "Turn off call waiting."))
                                arrayList26.add(
                                    CodeModel(
                                        str159,
                                        "Display information about Android Phone, Battery and Usage statistics "
                                    )
                                )
                                arrayList26.add(CodeModel(str158, "Android Device Ram version"))
                                arrayList26.add(
                                    CodeModel(
                                        "*#7465625*638*#",
                                        "Insert Network Keycode."
                                    )
                                )
                                arrayList26.add(CodeModel("*#0228#", "ADC Reading."))
                                arrayList26.add(
                                    CodeModel(
                                        "*#7465625*27*#",
                                        "Insert Content Provider Keycode."
                                    )
                                )
                                arrayList26.add(
                                    CodeModel(
                                        "*#225#",
                                        "Find out your current mobile account balance."
                                    )
                                )
                                arrayList26.add(
                                    CodeModel(
                                        "*#777#",
                                        "Find out prepaid mobile account balance."
                                    )
                                )
                                arrayList26.add(CodeModel(str175, "Number of missed calls."))
                                arrayList26.add(
                                    CodeModel(
                                        "*#646#",
                                        "Check minutes left on contract."
                                    )
                                )
                                arrayList26.add(CodeModel("*3001#12345#*", "Field test mode."))
                                arrayList26.add(CodeModel("*#5005*7672#", "SMS center number."))
                                arrayList26.add(CodeModel("*3370#", "Turn off or on EFR."))
                                arrayList26.add(
                                    CodeModel(
                                        "*#31#",
                                        "Hide your number on call option."
                                    )
                                )
                                binding.lvCodeList.adapter = CodeListAdapter(arrayList26, this)
                            }
                            else if (intExtra == "AMOL") {
                                binding.tvToolbar.text = "AMOL"
                                val arrayList27 = ArrayList<CodeModel>()
                                arrayList27.add(CodeModel(str174, str170))
                                arrayList27.add(CodeModel(" *3001#12345#*", "Field Mode"))
                                arrayList27.add(CodeModel(str139, "General Test Mode"))
                                arrayList27.add(CodeModel(str174, "Display your IMEI"))
                                arrayList27.add(CodeModel(str177, " Check Your Call Forwarding"))
                                arrayList27.add(
                                    CodeModel(
                                        str175,
                                        "Get Even More Info on Call Forwarding"
                                    )
                                )
                                arrayList27.add(CodeModel("*646#", "Check Your Available Minutes"))
                                arrayList27.add(CodeModel("*225#", "Check Your Bill Balance"))
                                arrayList27.add(CodeModel("#31#", "Hide Your Phone From Caller ID"))
                                arrayList27.add(CodeModel("*3282#", " Check Your Billing Cycle"))
                                arrayList27.add(CodeModel("*5005*7672#", " SMS Message Center"))
                                arrayList27.add(CodeModel("*43#", "Activate Call Waiting"))
                                arrayList27.add(
                                    CodeModel(
                                        "*#7353#",
                                        " Quick Test Menu (Samsung Galaxy Only)"
                                    )
                                )
                                arrayList27.add(
                                    CodeModel(
                                        " *#1234#",
                                        "Firmware (Samsung Galaxy Only)"
                                    )
                                )
                                arrayList27.add(CodeModel("*#43#", "Turn on call waiting."))
                                arrayList27.add(CodeModel("*#43#", "Turn off call waiting."))
                                arrayList27.add(
                                    CodeModel(
                                        str159,
                                        "Display information about Android Phone, Battery and Usage statistics "
                                    )
                                )
                                arrayList27.add(CodeModel(str158, " Android Device Ram version"))
                                arrayList27.add(
                                    CodeModel(
                                        "*#7465625*638*#",
                                        "Insert Network Keycode."
                                    )
                                )
                                binding.lvCodeList.adapter = CodeListAdapter(arrayList27, this)
                            } else {
                                if (intExtra == "BQ") {
                                    binding.tvToolbar.text = "BQ"
                                    val arrayList28 = ArrayList<CodeModel>()
                                    arrayList28.add(CodeModel(str174, str170))
                                    arrayList28.add(CodeModel(str164, " Quick GPS Test"))
                                    arrayList28.add(
                                        CodeModel(
                                            "*#*#1575#*#*",
                                            " A Different Type GPS Test"
                                        )
                                    )
                                    arrayList28.add(
                                        CodeModel(
                                            str153,
                                            "Android Device LCD display test"
                                        )
                                    )
                                    arrayList28.add(
                                        CodeModel(
                                            str90,
                                            "Vibration and Backlight test"
                                        )
                                    )
                                    arrayList28.add(
                                        CodeModel(
                                            str136,
                                            "Android Device Touch-Screen test"
                                        )
                                    )
                                    arrayList28.add(CodeModel(str165, " Proximity sensor test"))
                                    arrayList28.add(
                                        CodeModel(
                                            "*#*#7262626#*#*",
                                            "Device Field test"
                                        )
                                    )
                                    arrayList28.add(CodeModel(str166, "Device Wireless Lan Test"))
                                    arrayList28.add(
                                        CodeModel(
                                            "*#*#526#*#*",
                                            " Device Wireless Lan Test"
                                        )
                                    )
                                    arrayList28.add(CodeModel("*#*#0289#*#*", " Device Audio test"))
                                    arrayList28.add(CodeModel("*#*#0673#*#*", " Device Audio test"))
                                    arrayList28.add(CodeModel(str169, "Device Bluetooth test"))
                                    arrayList28.add(
                                        CodeModel(
                                            "*#*#0283#*#*",
                                            "Packet Loopback test"
                                        )
                                    )
                                    arrayList28.add(
                                        CodeModel(
                                            str159,
                                            "Display information about Android Phone, Battery and Usage statistics"
                                        )
                                    )
                                    arrayList28.add(
                                        CodeModel(
                                            str159,
                                            " Shows complete information about the Device camera"
                                        )
                                    )
                                    arrayList28.add(
                                        CodeModel(
                                            " *#*#34971539#*#*",
                                            " The displays touch-screen version of Android device"
                                        )
                                    )
                                    arrayList28.add(
                                        CodeModel(
                                            "*#*#2663#*#*",
                                            "Android Device Ram version*#06# Displays IMEI number"
                                        )
                                    )
                                    arrayList28.add(
                                        CodeModel(
                                            str158,
                                            " Displays Bluetooth device address"
                                        )
                                    )
                                    arrayList28.add(
                                        CodeModel(
                                            " *#*#232337#*#",
                                            " Displays Wi-Fi Mac-address"
                                        )
                                    )
                                    arrayList28.add(
                                        CodeModel(
                                            str178,
                                            "PDA and Device firmware info"
                                        )
                                    )
                                    arrayList28.add(CodeModel(str173, " FTA Software version"))
                                    arrayList28.add(CodeModel(str171, " FTA Hardware version"))
                                    arrayList28.add(CodeModel(str172, " FTA Hardware version "))
                                    arrayList28.add(
                                        CodeModel(
                                            "*#*#44336#*#*\t",
                                            " Displays Build time and change list number "
                                        )
                                    )
                                    binding.lvCodeList.adapter = CodeListAdapter(arrayList28, this)
                                }

                                val str180 = str178
                                val str181 = str174
                                val str182 = str177
                                val str183 = str175
                                val str184 = str139
                                val str185 = str172
                                val str186 = str171
                                val str187 = str173
                                val str188 = str90

                                if (intExtra == "I-Mobile") {
                                    binding.tvToolbar.text = "I-Mobile"
                                    val arrayList29 = arrayListOf<CodeModel>(
                                        CodeModel(str159, "Shows Information about phone"),
                                        CodeModel(str176, "Factory Reset your smartphone."),
                                        CodeModel(str142, "Hard Reset & Reinstall the Firmware."),
                                        CodeModel(str141, "Displays information about the camera."),
                                        CodeModel(
                                            "*#*#7594#*#*",
                                            "Changes the power button behavior."
                                        ),
                                        CodeModel(
                                            "*#*#273283*255*663282*#*#*",
                                            "Back up all media files stored on your device."
                                        ),
                                        CodeModel(str106, "This opens the Service Mode."),
                                        CodeModel(str166, "Test the state of Wireless LAN"),
                                        CodeModel(str180, "Display the MAC Address of WiF"),
                                        CodeModel(
                                            str169,
                                            "Test the Bluetooth sensor of your device."
                                        ),
                                        CodeModel(
                                            "*#*#232337#*#",
                                            "This Shows the Bluetooth Device Address."
                                        ),
                                        CodeModel("*#*#44336#*#*", "Display the Build time."),
                                        CodeModel(
                                            str187,
                                            "Displays the PDA and Phone Firmware Info"
                                        ),
                                        CodeModel(str165, "Tests the Proximity Sensor"),
                                        CodeModel(str164, "This Tests the GPS functionality"),
                                        CodeModel(str153, "Test the phone’s LCD Display"),
                                        CodeModel(
                                            "*#*#0673#*#*",
                                            "Test the Audio of your smartphone"
                                        ),
                                        CodeModel(str188, "Tests the Vibration and Backlight"),
                                        CodeModel(
                                            "*#*#8255#*#*",
                                            "Google Talk Service Monitoring."
                                        ),
                                        CodeModel(
                                            "*#*#2663#*#*",
                                            "Displays the Touchscreen version."
                                        ),
                                        CodeModel(
                                            str136,
                                            "Allows you to perform a touch screen test"
                                        )
                                    )
                                    binding.lvCodeList.adapter = CodeListAdapter(arrayList29, this)
                                }
                                else if (intExtra == "LEECO") {
                                    binding.tvToolbar.text = "LEECO"
                                    val arrayList30 = arrayListOf<CodeModel>(
                                        CodeModel(str158, "Displays RAM information"),
                                        CodeModel(str186, "Displays the software version."),
                                        CodeModel(str185, "Displays the hardware version."),
                                        CodeModel(str181, "It Displays the phone’s IMEI number."),
                                        CodeModel("*#2263#", "Displays the RF band selection"),
                                        CodeModel("*#9090#", "Shows the Diagnostic configuration."),
                                        CodeModel(
                                            "*#7284#",
                                            "This opens the USB 12C mode control."
                                        ),
                                        CodeModel(str152, "This shows the USB logging control."),
                                        CodeModel("*#745#", "This opens the RIL dump menu."),
                                        CodeModel("*#746#", "This opens the Debug dump menu."),
                                        CodeModel(str140, "Opens the System dump mode."),
                                        CodeModel("*#03#", "NAND flash serial number"),
                                        CodeModel("*#3214789#", "This shows the GCF mode Status"),
                                        CodeModel("*#7353#", "Opens the Quick test menu"),
                                        CodeModel(
                                            "*#0782#",
                                            "This performs a Real-time clock test."
                                        ),
                                        CodeModel("*#0589#", "This performs a Light sensor test"),
                                        CodeModel(
                                            "##7764726",
                                            "It opens the hidden service menu in Motorola ANDROID phones"
                                        ),
                                        CodeModel(
                                            "1809#*990#",
                                            "It opens the LG Optimus 2x hidden service menu"
                                        ),
                                        CodeModel(
                                            "3845#*920#",
                                            "It opens the LG Optimus 3D hidden service menu"
                                        ),
                                        CodeModel(
                                            str184,
                                            "It opens the service menu in Galaxy S3."
                                        ),
                                        CodeModel(str182, "Displays your Call forwarding"),
                                        CodeModel(
                                            str183,
                                            "Displays additional call forwarding information"
                                        ),
                                        CodeModel("*646#", "Displays Available minutes (AT&T)")
                                    )
                                    binding.lvCodeList.adapter = CodeListAdapter(arrayList30, this)
                                }


                            }

                        }
                    }
                }

            }
        }
    }
}