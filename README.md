# Custom Inventory Management System

Custom inventory management software is a comprehensive web application designed specifically for retail stores to streamline and enhance their inventory management processes. It provides a user-friendly interface and a range of features to efficiently manage inventory, track item quantities, and optimize stock control. The software allows users to create and define zones within their store, assign items to specific locations, and track real-time stock quantities across different areas.

It enables users to capture and manage item details, such as name, description, and supplier information, facilitating accurate item tracking and identification. Additionally, the software may offer reporting and analytics capabilities to generate insights on inventory performance. The software aims to improve organizational efficiency, prevent stockouts, optimize inventory levels, and enhance customer satisfaction through improved inventory availability


## Features

##### Login and Sign Up

User authentication modules are built using bootstrap and React-bootstrap and focused on user friendly design. Both takes the parameters email and name to authenticate, once the user logs in the details will be stored in cookies for further convenience and features which will be removed after logout event occurs, to sign up to the portal it also requires email and name which will be verified and stored in the database, once the registration is done user can proceed with login.

##### Zone Functionality

The store offers a feature called "zones," which allows the organization and storage of inventory. Users can create new zones to categorize items and delete existing zones if needed.

##### Item Management

The system allows users to manage inventory items within the designated zones. Users have the ability to add new items to specific zones along with their respective quantities. They can also change the quantities of existing items within zones and remove items altogether. The user will also be notified when the quantity goes below the threshold quantity value. Additionally, the system will send notifications to the user when an item's quantity falls below a predefined threshold value.

##### Searching Items

The search functionality provides the users with the option to search the items either in the entire store or in specific zones of the store.

## Project Workflow

<ol>
    <li>User registers using email and store name.</li>
    <li>User gets redirected to login.</li>
    <li>User logs in using email and store name.</li>
    <li>Once logged in user will add different zones available in the inventory.</li>
    <li>User will add the products or items available in particular zones.</li>
    <li>User will search for a product, it can be done for specific zone or entire store.</li>
    <li>User will monitor the increase and decrease in the item quatity.</li>
    <li>User will logout to exit the portal.</li>
</ol>

## Deployment

### Backend

<ol>
    <li>Write dockerfile and cloud buid.yaml file.</li>
    <li>Create a service in cloud run.</li>
    <li>Connect github repository to cloud run service.</li>
    <li>This setup will create a ci/cd pipeline by using dockerfile and cloud build.</li>
</ol>


