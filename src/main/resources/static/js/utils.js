const REQUEST_TYPE = {
    GET: 'GET',
    POST: 'POST',
    PATCH: 'PATCH',
    PUT: 'PUT',
    DELETE: 'DELETE'
}
const requestFn = (type, endPoint, param, callback) => {
    fetch(endPoint, {
        method: type,
        headers: {
        'Content-Type': 'application/json'
        },
        body:JSON.stringify(param)
    })
        .then((response) => {
            if (!response.ok)
                throw new Error('400 or 500 Error')
            callback(response)
        })
}