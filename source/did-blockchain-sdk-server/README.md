# Server Blockchain SDK Guide
This document serves as a guide for using the OpenDID Server Blockchain SDK. It provides functionality to invoke chaincode and generate transaction requests necessary to record DID Document and Verifiable Credential Metadata (VC Meta) information on the blockchain for OpenDID.

## S/W Specifications
| Category       | Details    |
|----------------|------------|
| Language       | Java 17    |
| Build System   | Gradle 8.8 |

<br>

## Build Method
1. Open a terminal and navigate to the project root directory, then run `./gradlew clean build`.
2. Once the build is complete, the `did-blockchain-sdk-server-1.0.0.jar` file will be generated in the `build/libs` directory.

<br>

## SDK Application Method
1. Copy the `did-datamodel-server-1.0.0.jar` file into the project's `libs` directory.
2. Add the following dependencies to the project's `build.gradle` file:
```groovy
    implementation files('libs/did-datamodel-server-1.0.0.jar')
    implementation('org.hyperledger.fabric:fabric-gateway-java:2.2.9')
    implementation('com.fasterxml.jackson.core:jackson-databind:2.15.2')
    implementation('org.apache.commons:commons-pool2:2.12.0')
    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation('org.junit.jupiter:junit-jupiter')
    annotationProcessor('com.fasterxml.jackson.core:jackson-databind:2.15.2')
    annotationProcessor('org.projectlombok:lombok:1.18.28')
    compileOnly('org.projectlombok:lombok:1.18.28')
```
3. Synchronize `Gradle` to ensure that the dependencies are correctly added.

## API Documentation
| Category | API Documentation Link |
|----------|-------------------------|
| FabricContractApi  | [Blockchain SDK - FabricContractApi API](../../docs/api/Blockchain_API.md) |
| ErrorCode          | [Error Code](../../docs/api/BlockchainErrorCode.md) |

### FabricContractApi
The FabricContractApi provides functionality to interact with chaincode by creating transactions related to DID documents and VC Meta, based on the Blockchain Network configuration information.<br>Key features include:

* <b>Register DID Document</b>: Registers a new DID document and saves its state.
* <b>Update DID Document</b>: Modifies an existing DID document.
* <b>Retrieve DID Document</b>: Retrieves a specific DID document and its state.
* <b>Change DID Document State</b>: Changes the state of a DID document.
* <b>Register VC Meta</b>: Registers VC metadata.
* <b>Change VC Meta State</b>: Updates the state of VC metadata.
* <b>Retrieve VC Meta</b>: Retrieves specific VC metadata.
