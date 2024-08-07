import OrderHistoryList  from "../Components/OrderHistoryList";
import { useLoaderData, json, defer } from 'react-router-dom';
import { getAuthToken } from "../util/auth";

function OrderHistoryPage(){
    const orderHistory  = useLoaderData();
    
   return(
    <OrderHistoryList orderHistory = {orderHistory}/>
   )
   

} 

export default OrderHistoryPage;

export async function loader() {

    const token = getAuthToken();
    const response = await fetch(process.env.REACT_APP_BASEURL+'orders',{
        method: "GET",
        headers: {
          'Authorization': 'Bearer ' + token,
        }
      });
  
    if (!response.ok) {
      // return { isError: true, message: 'Could not fetch events.' };
      // throw new Response(JSON.stringify({ message: 'Could not fetch events.' }), {
      //   status: 500,
      // });
      throw json(
        { message: 'Could not fetch events.' },
        {
          status: 500,
        }
      );
    } else {
      const resData = await response.json();
     //  console.log("Response Data: "+resData.orders[0].productName)
      return resData.orders;
    }
  }