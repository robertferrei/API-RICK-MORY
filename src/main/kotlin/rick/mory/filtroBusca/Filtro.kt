package org.example.rick.mory.filtroBusca

data class Filtro (val name:String,val status:String,val type:String){ //construtor

override fun toString(): String {
            return "Nome personagem:${name}, status:${status}, Tipo de personagem:${type}"
        }
   }

