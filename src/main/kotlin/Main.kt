package org.example

import org.example.rick.mory.modelo.Episode
import org.example.rick.mory.modelo.InfoPersonagem
import org.example.rick.mory.modelo.Personagem
import org.example.rick.mory.servicos.ConsumoApi
import java.util.Scanner

fun main() {
    //leitura de dados
    val leitura = Scanner(System.`in`)
    println("digite o id do personagem que deseja buscar:")
    val busca = leitura.nextLine() //leitura de linha inteira
    //fim leitura

    //consumoAPi
    val buscaApi = ConsumoApi()
    val informacao = buscaApi.buscaName(busca) //buscando  por ID
    //fim ConsumoAPi

    //buscaDeInformações
    val resultadoBusca = runCatching { //tratando dados
    val  personagem = Personagem(informacao.name, informacao.image,informacao.status,informacao.type)
    println(personagem)
    }
    resultadoBusca.onFailure {
        println("personagem inexistente ")
    }
    //finalizando busca de informações de personagem

    //inicio
    println("deseja escolher algum episodio S/N")
    val buscaEp = leitura.nextLine()

    if(buscaEp.equals("s", ignoreCase = true)){
        println("escolha o numero do episodio que deseja assistir:")
        val ep = leitura.nextLine()
        val episodio = buscaApi.buscaEpisode(ep)

        val episode = Episode(episodio.name,episodio.url)
        println(episode)

    }else{
        println("finalizando programa")
    }

}