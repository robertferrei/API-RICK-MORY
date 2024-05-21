package org.example.rick.mory.servicos

import com.google.gson.Gson
import org.example.rick.mory.modelo.InfoAPi
import org.example.rick.mory.modelo.Personagem
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {
    fun buscaName(id:String):Personagem{
        val endereco = "https://rickandmortyapi.com/api/character/$id"

        val client: HttpClient = HttpClient.newHttpClient()  //requisição
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client //resposta
            .send(request, BodyHandlers.ofString())
        val json = response.body()
        println(json)
        val jsoon = Gson()
        val meuInfoPersonagem = jsoon.fromJson(json,Personagem::class.java)
        return  meuInfoPersonagem
    }
}