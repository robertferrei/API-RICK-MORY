package org.example.rick.mory.modelo

data class Episode(val name:String,val url:String){
    override fun toString(): String {
        return "Nome do episodio: ${name}, link para acesso de episodio: ${url}"
    }
}
