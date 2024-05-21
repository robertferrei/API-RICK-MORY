package org.example.rick.mory.modelo

data class Personagem(val name: String, val image: String,val status:String, val type:String){ //construtor
    override fun toString(): String {
        return "Nome personagem:${name},imagem:${image},status:${status}, Tipo de personagem:${type}"
    }
}