package k2b6s9j.BoatCraft.boat.wood.spruce

object Chest {

  class Entity extends EntityBoatContainer {

  }

  class Item extends ItemCustomBoat {

  }

  class Render extends RenderBoat {

    override def getEntity(): EntityCustomBoat = {
      val entity: Entity =  null
      return entity
    }

  }

}