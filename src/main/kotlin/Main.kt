package org.example

import org.example.rick.mory.filtroBusca.Filtro
import org.example.rick.mory.filtroBusca.FiltroResult
import org.example.rick.mory.modelo.Episode
import org.example.rick.mory.modelo.InfoPersonagem
import org.example.rick.mory.modelo.Personagem
import org.example.rick.mory.servicos.ConsumoApi
import java.util.Scanner

fun main() {
    //-->leitura de dados
    val leitura = Scanner(System.`in`)
    println("digite o id do personagem que deseja buscar:")
    val busca = leitura.nextLine() //leitura de linha inteira
    //-->fim leitura

    //-->consumoAPi
    val buscaApi = ConsumoApi()
    val informacao = buscaApi.buscaName(busca) //buscando  por ID
    //-->fim ConsumoAPi

    //-->buscaDeInformações
    val resultadoBusca = runCatching { //tratando dados
    val  personagem = Personagem(informacao.name, informacao.image,informacao.status,informacao.type)
    println(personagem)
    }
    resultadoBusca.onFailure {
        println("personagem inexistente ")
    }
    //-->finalizando busca de informações de personagem

    //-->inicio busca de episodios
    println("deseja escolher algum episodio S/N")
    val buscaEp = leitura.nextLine()

    if(buscaEp.equals("s", ignoreCase = true)){
        println("escolha o numero do episodio que deseja assistir:")

        val ep = leitura.nextLine()
        val episodio = buscaApi.buscaEpisode(ep)

        val resultadoEpisode = runCatching {
            val episode = Episode(episodio.name, episodio.url)
            println(episode)
        }
        resultadoEpisode.onFailure {
            println("episodio Não existe ate o momento")
        }
    }else{
        println("finalizando busca de episodios")
    }
    //---> fim de busca de episodios

    //---> busca por filtros
    println("deseja estar buscando por filtros de espécies e status de personagem S/N")
    val  buscaBoleanaFiltro =  leitura.nextLine()

    if(buscaBoleanaFiltro.equals("s",ignoreCase = true)){
        println("digite o nome da especie")
        val filterSpecies = leitura.nextLine()
        println("digite o status")
        val filterStatus = leitura.nextLine()

        var meufiltro: Filtro? //filtro pode ser null
        val  buscafiltro = buscaApi.buscaFiltro(filterSpecies,filterStatus)



        val resultadoFiltro = runCatching {
        //val filtro = Filtro(buscafiltro.results.name,buscafiltro.results.status,buscafiltro.results.type)
          //  println(filtro)
            val filtro = buscafiltro.results.joinToString(separator = "\n----\n") { filtro ->
                filtro.toString()
            }
            println(filtro)
      }
    resultadoFiltro.onFailure {
        println("filtros passados estão incorretos")
     }
    }
    else{
        println("busca de filtros encerrados")
    }
    // ---> finalizando busca  por filtros
}