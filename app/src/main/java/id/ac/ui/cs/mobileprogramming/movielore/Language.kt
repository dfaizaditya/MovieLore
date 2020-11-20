package id.ac.ui.cs.mobileprogramming.movielore

import java.io.Serializable


class Language(name: String, code: String) : Serializable {

    var name: String? = name
    var code: String? = code

    companion object {

        fun getLanguageList(): ArrayList<Language> {
            val list = ArrayList<Language>()
            list.add(Language("Select Language", "lang"))
            list.add(Language("English", "en"))
            list.add(Language("Indonesia", "in"))
            list.add(Language("Italia", "it"))
            return list
        }
    }
}