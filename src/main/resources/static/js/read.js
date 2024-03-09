window.addEventListener('load', () => {
    const id = document.querySelector('#id')
    const editBtn = document.querySelector('#editBtn')
    const delBtn = document.querySelector('#delBtn')

    editBtn.hidden = false
    delBtn.hidden = false

    editBtn.addEventListener('click', () => {
        location.href = `/postWrite/${id.value}`
    })
})