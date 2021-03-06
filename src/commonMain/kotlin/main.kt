import com.soywiz.korge.Korge
import com.soywiz.korge.input.onClick
import com.soywiz.korge.scene.Module
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.ui.uiTextButton
import com.soywiz.korge.view.Container
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korio.async.launchImmediately
import kotlin.reflect.KClass

suspend fun main() = Korge(Korge.Config(module = MyModule))

object MyModule : Module() {
	override val mainScene: KClass<out Scene> = MainScene::class

	override suspend fun init(injector: AsyncInjector): Unit =injector.run  {
		mapPrototype { MainScene() }
	}
}

class MainScene() : Scene() {
	override suspend fun Container.sceneInit() {
		uiTextButton(text="1")
	}
}