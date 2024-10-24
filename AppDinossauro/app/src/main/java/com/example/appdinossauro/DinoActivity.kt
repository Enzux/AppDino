package com.example.appdinossauro

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.SurfaceView
import com.google.android.filament.*
import com.google.android.filament.EntityManager
import com.google.android.filament.gltfio.Animator
import com.google.android.filament.gltfio.AssetLoader
import com.google.android.filament.gltfio.FilamentAsset
import com.google.android.filament.gltfio.MaterialProvider
import com.google.android.filament.gltfio.ResourceLoader
import java.nio.ByteBuffer

class DinoActivity: AppCompatActivity() {

    private lateinit var surfaceView: SurfaceView
    private lateinit var engine: Engine
    private lateinit var renderer: Renderer
    private lateinit var scene: Scene
    private lateinit var view: View
    private lateinit var camera: Camera
    private lateinit var swapChain: SwapChain
    private lateinit var assetLoader: AssetLoader
    private lateinit var resourceLoader: ResourceLoader
    private lateinit var asset: FilamentAsset

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        enableEdgeToEdge()
        setContentView(R.layout.dinolayout)

        surfaceView = findViewById(R.id.surfaceView)

        // Inicializar o Filament
        engine = Engine.create()

        // Configurar o renderizador
        renderer = engine.createRenderer()

        // Criar o SwapChain para desenhar no SurfaceView
        swapChain = engine.createSwapChain(surfaceView.holder.surface)

        val materials = MaterialProvider(engine)
        assetLoader = AssetLoader(engine, materials, EntityManager.get())
        resourceLoader = ResourceLoader(engine)


        // Criar a cena e adicionar uma luz
        scene = engine.createScene()

        // Criar a câmera
        val cameraEntity = EntityManager.get().create()
        camera = engine.createCamera(cameraEntity)
        camera.setExposure(1.0f, 1.2f, 1000.0f)

        // Configurar a View que exibirá a cena
        view = engine.createView()
        view.scene = scene
        view.camera = camera

        // Adicionar luz ambiente
        addLight()

        // Carregar e renderizar o modelo 3D GLTF
        loadModel("trex.gltf")


        val intent = intent
        val action = intent.action
        val data = intent.data

        if (Intent.ACTION_VIEW == action && data != null) {
            // Aqui você pode lidar com dados extras se necessário
            // Exemplo: val param = data.getQueryParameter("param")
        }
    }

    private fun addLight() {
        val sunlight = EntityManager.get().create()
        LightManager.Builder(LightManager.Type.SUN)
            .castShadows(true)
            .direction(0.0f, -1.0f, -1.0f)
            .build(engine, sunlight)
        scene.addEntity(sunlight)
    }

    private fun loadModel(filename: String) {
        val buffer = assets.open(filename).use { input ->
            val bytes = ByteArray(input.available())
            input.read(bytes)
            ByteBuffer.wrap(bytes)
        }

        asset = assetLoader.createAssetFromBinary(buffer)!!
        resourceLoader.loadResources(asset)
        scene.addEntities(asset.entities)
    }
    override fun onDestroy() {
        super.onDestroy()

        // Liberar recursos
        engine.destroyRenderer(renderer)
        engine.destroyView(view)
        engine.destroyScene(scene)
        engine.destroyCamera(camera)
        assetLoader.destroyAsset(asset)
        engine.destroySwapChain(swapChain)
        engine.destroy()
    }
}





