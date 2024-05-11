package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStoreInterface mockPrimaryTorpedoStore;
  private TorpedoStoreInterface mockSecondaryTorpedoStore;

  @BeforeEach
  public void init(){
    mockPrimaryTorpedoStore = mock(TorpedoStoreInterface.class);
    mockSecondaryTorpedoStore = mock(TorpedoStoreInterface.class);

    this.ship = new GT4500(mockPrimaryTorpedoStore, mockSecondaryTorpedoStore);
  }

  @Test
  public void fireTorpedo_Single_Success(){

    when(mockPrimaryTorpedoStore.fire(1)).thenReturn(true);
    
    ship.fireTorpedo(FiringMode.SINGLE);

    verify(mockPrimaryTorpedoStore).fire(1);

  }

  @Test
  public void fireTorpedo_All_Success(){
  
    when(mockPrimaryTorpedoStore.fire(1)).thenReturn(true);
    when(mockSecondaryTorpedoStore.fire(1)).thenReturn(true);

    
    ship.fireTorpedo(FiringMode.ALL);

    verify(mockPrimaryTorpedoStore).fire(1);
    verify(mockSecondaryTorpedoStore).fire(1);

  }

  @Test
  public void fireTorpedo_Single_11(){
    ship.fireTorpedo(FiringMode.SINGLE);

    verify(mockPrimaryTorpedoStore).fire(1);
    verify(mockSecondaryTorpedoStore, never()).fire(1);

  }
  @Test
  public void fireTorpedo_Single(){
    for (int i = 0; i <= 15; i++){
    ship.fireTorpedo(FiringMode.SINGLE);

    }
  
  }
  @Test
  public void fireTorpedo_All(){
    for (int i = 0; i <= 15; i++){
    ship.fireTorpedo(FiringMode.ALL);

    }
  
  }

}
