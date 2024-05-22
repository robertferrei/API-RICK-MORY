package org.example.rick.mory.filtroBusca

data class FiltroResult(val results:List<Filtro> ){
    override fun toString(): String {
        //return results.toString()
        return results.joinToString(separator = "\n") { it.toString() }
    }
}

