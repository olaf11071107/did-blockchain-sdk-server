/*
 * Copyright 2024 Raonsecure
 */

package org.omnione.did;

import org.omnione.did.fabric.FabricContractApi;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.cert.CertificateException;

/**
 * Enum {@code ContractFactory} provides a way to create {@code ContractApi} instances based on different
 * implementations.
 * <p>
 * This enum defines different implementations of {@code ContractApi} that can be created by specifying a property path.
 * The current implementation includes support for Hyperledger Fabric.
 * </p>
 */
public enum ContractFactory {

  /**
   * An implementation of {@code ContractFactory} for creating {@code FabricContractApi} instances.
   */
  FABRIC {
    protected ContractApi getContractApi(String propertyPath) {
      try {
        return new FabricContractApi(propertyPath);
      } catch (CertificateException | IOException | InvalidKeyException e) {
        throw new RuntimeException(e);
      }
    }
  };

  /**
   * Factory method for creating an instance of {@code ContractApi} using the specified property path.
   *
   * @param propertyPath the path to the resource files required for the blockchain network
   * @return an instance of ContractApi
   */
  public ContractApi create(String propertyPath) {
    return getContractApi(propertyPath);
  }

  /**
   * Abstract method to be implemented by each enum constant to create a specific implementation of
   * {@code ContractApi}.
   *
   * @param propertyPath the path to the resource files required for the blockchain network
   * @return an instance of {@code ContractApi}.
   */
  abstract protected ContractApi getContractApi(String propertyPath);
}
